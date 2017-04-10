package no.firma.oppgave.model;

/**
 * Created by p on 27/01/2017.
 */
public class Weather {

    private String TimeFrom;
    private String TimeTo;
    private String SymbolNumber;
    private String SymbolName;
    private String PrecipitationValue;
    private String WindDirectionName;
    private String WindSpeedMps;
    private String WindSpeedName;
    private String TemperatureValue;
    private String TemperatureUnit;
    private String PressureValue;
    private String PressureUnit;

    public Weather() {

    }


    public Weather(String timeFrom, String timeTo, String symbolNumber, String symbolName, String precipitationValue, String windDirectionName, String windSpeedMps, String windSpeedName, String temperatureValue, String temperatureUnit, String pressureValue, String pressureUnit) {
        this.TimeFrom = timeFrom;
        this.TimeTo = timeTo;
        this.SymbolNumber = symbolNumber;
        this.SymbolName = symbolName;
        this.PrecipitationValue = precipitationValue;
        this.WindDirectionName = windDirectionName;
        this.WindSpeedMps = windSpeedMps;
        this.WindSpeedName = windSpeedName;
        this.TemperatureValue = temperatureValue;
        this.TemperatureUnit = temperatureUnit;
        this.PressureValue = pressureValue;
        this.PressureUnit = pressureUnit;
    }

    public String getTimeFrom() {
        return TimeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        TimeFrom = timeFrom;
    }

    public String getTimeTo() {
        return TimeTo;
    }

    public void setTimeTo(String timeTo) {
        TimeTo = timeTo;
    }

    public String getSymbolNumber() {
        return SymbolNumber;
    }

    public void setSymbolNumber(String symbolNumber) {
        SymbolNumber = symbolNumber;
    }

    public String getSymbolName() {
        return SymbolName;
    }

    public void setSymbolName(String symbolName) {
        SymbolName = symbolName;
    }

    public String getPrecipitationValue() {
        return PrecipitationValue;
    }

    public void setPrecipitationValue(String precipitationValue) {
        PrecipitationValue = precipitationValue;
    }

    public String getWindDirectionName() {
        return WindDirectionName;
    }

    public void setWindDirectionName(String windDirectionName) {
        WindDirectionName = windDirectionName;
    }

    public String getWindSpeedMps() {
        return WindSpeedMps;
    }

    public void setWindSpeedMps(String windSpeedMps) {
        WindSpeedMps = windSpeedMps;
    }

    public String getWindSpeedName() {
        return WindSpeedName;
    }

    public void setWindSpeedName(String windSpeedName) {
        WindSpeedName = windSpeedName;
    }

    public String getTemperatureValue() {
        return TemperatureValue;
    }

    public void setTemperatureValue(String temperatureValue) {
        TemperatureValue = temperatureValue;
    }

    public String getTemperatureUnit() {
        return TemperatureUnit;
    }

    public void setTemperatureUnit(String temperatureUnit) {
        TemperatureUnit = temperatureUnit;
    }

    public String getPressureValue() {
        return PressureValue;
    }

    public void setPressureValue(String pressureValue) {
        PressureValue = pressureValue;
    }

    public String getPressureUnit() {
        return PressureUnit;
    }

    public void setPressureUnit(String pressureUnit) {
        PressureUnit = pressureUnit;
    }
}
