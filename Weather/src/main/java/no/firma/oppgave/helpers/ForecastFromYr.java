package no.firma.oppgave.helpers;

import no.firma.oppgave.model.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by p on 04/01/2017.
 */
public class ForecastFromYr {

    private static final Logger log = LoggerFactory.getLogger("ForecastFromYr");

    static private String timeFrom;
    static private String timeTo;
    static private String symbolNumber;
    static private String symbolName;
    static private String precipitationValue;
    static private String windDirectionName;
    static private String windSpeedMps;
    static private String windSpeedName;
    static private String temperatureUnit;
    static private String temperatureValue;
    static private String pressureUnit;
    static private String pressureValue;

    static private Weather weather = new Weather();
    static private int initLen = ForecastFromYr.createForecastReport().length();

    public static String fetchReport(String forecastUrl) {
        Document doc = readFromUrl(forecastUrl);
        return getWeatherLikeNow(doc);
    }

    public static String createForecastReport() {
        return   "Vær fra " + timeFrom + " til "+ timeTo + " \n " +
                "Nivå "+symbolNumber + " - " + symbolName + " \n " +
                "Regn: " + precipitationValue + " \n " +
                "Vind kommer fra " + windDirectionName + " med " + windSpeedMps + "mps - " + windSpeedName + " \n " +
                "Temperature: " + temperatureValue + " " + temperatureUnit + " \n " +
                "Trykk: " + pressureValue + " " + pressureUnit + " \n " + " \n " +
                "ved Pedro Alves via yr.no";
    }

    public static String fetchReportTest(String forecastFile) {
        Document doc = readFromFile(forecastFile);
        return getWeatherLikeNow(doc);
    }

    private static Document readFromUrl(String forecastUrl){
        URL oracle;
        Document doc = null;
        DocumentBuilder dBuilder;
        DocumentBuilderFactory dbFactory
                = DocumentBuilderFactory.newInstance();

        try {
            oracle = new URL(forecastUrl);
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(oracle.openStream());
            doc.getDocumentElement().normalize();
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        } catch (ParserConfigurationException e) {
            log.error(e.getMessage());
        }catch (SAXException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return doc;
    }

    private static Document readFromFile(String filenamepath){
        Document doc = null;
        DocumentBuilder db = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            db = dbf.newDocumentBuilder();
            File file = new File(filenamepath);
            doc = db.parse(file);
        } catch (ParserConfigurationException e) {
            log.error(e.getMessage());
        } catch (SAXException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return doc;
    }

    private static String getWeatherLikeNow(Document doc) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        NodeList timeList = doc.getElementsByTagName("time");

        for (int temp = 0; temp < timeList.getLength(); temp++) {
            Node timeNode = timeList.item(temp);
            if(timeNode.getParentNode().getNodeName().equals("tabular")) {
                if (timeNode.getNodeType() == Node.ELEMENT_NODE) {
                    /*
                    <time from="2017-01-08T19:00:00" to="2017-01-08T20:00:00">
                        <symbol number="4" numberEx="4" name="Skyet" var="04"/>
                        <precipitation value="0"/>
                        <windDirection deg="263.3" code="W" name="Vest"/>
                        <windSpeed mps="13.1" name="Liten kuling"/>
                        <temperature unit="celsius" value="7"/>
                        <pressure unit="hPa" value="1015.9"/>
                    </time>
                     */
                    Element time = (Element) timeNode;
                    timeFrom = LocalDateTime.parse(getAttrByElem(time, "from")).format(formatter);
                    timeTo = LocalDateTime.parse(getAttrByElem(time, "to")).format(formatter);
                    weather.setTimeFrom(timeFrom);
                    weather.setTimeTo(timeTo);

                    Element symbol = getElementByTagName(timeNode, "symbol");
                    symbolNumber = getAttrByElem(symbol, "number");
                    String symbolNumberEx = getAttrByElem(symbol,"numberEx");
                    symbolName = getAttrByElem(symbol, "name");
                    weather.setSymbolNumber(symbolNumber);
                    weather.setSymbolName(symbolName);

                    Element precipitation = getElementByTagName(timeNode, "precipitation");
                    precipitationValue = getAttrByElem(precipitation, "value");
                    weather.setPrecipitationValue(precipitationValue);

                    Element windDirection = getElementByTagName(timeNode, "windDirection");
                    String windDirectionDeg = getAttrByElem(windDirection, "deg");
                    String windDirectionCode = getAttrByElem(windDirection, "code");
                    windDirectionName = getAttrByElem(windDirection, "name");
                    weather.setWindDirectionName(windDirectionName);

                    Element windSpeed = getElementByTagName(timeNode, "windSpeed");
                    windSpeedMps = getAttrByElem(windSpeed, "mps");
                    windSpeedName = getAttrByElem(windSpeed, "name");
                    weather.setWindSpeedMps(windSpeedMps);
                    weather.setWindSpeedName(windSpeedName);

                    Element temperature = getElementByTagName(timeNode, "temperature");
                    temperatureUnit = getAttrByElem(temperature, "unit");
                    temperatureValue = getAttrByElem(temperature, "value");
                    weather.setTemperatureValue(temperatureValue);
                    weather.setTemperatureUnit(temperatureUnit);

                    Element pressure = getElementByTagName(timeNode, "pressure");
                    pressureUnit = getAttrByElem(pressure, "unit");
                    pressureValue = getAttrByElem(pressure, "value");
                    weather.setPressureValue(pressureValue);
                    weather.setPressureUnit(pressureUnit);

                    break;
                }
            }
        }
        return createForecastReport();
    }

    private static String getAttrByElem(Element elem, String name) {
        if(elem != null) {
            return elem.getAttribute(name);
        }

        return "";
    }

    private static Element getElementByTagName(Node node, String name) {
        if (node != null) {
            NodeList nodeList =  ((Element) node).getElementsByTagName(name);
            if (nodeList != null && nodeList.getLength() > 0) {
                Node fNode = nodeList.item(0);
                if(fNode != null) {
                    return (Element)fNode;
                }
            }
        }

        return null;
    }

    public static Weather getWeather() {
        return weather;
    }

    public static int getInitLen() {
        return initLen;
    }

}
