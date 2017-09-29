package no.book.order.contractorders;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

public class OrderServiceSoapHeaderInInterceptor extends AbstractSoapInterceptor {

	public OrderServiceSoapHeaderInInterceptor() {
		super(Phase.USER_PROTOCOL);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		
	  // Set the qualified name using the orders web service namespace and the
      // local part name of apikey.
      QName qname = new QName("http://www.bookcontract.com/service/Orders/",
            "apikey");

      // Get the SOAP header from the message using the qualified name.
      SoapHeader header = (SoapHeader) message.getHeader(qname);

      // Get the element from the soap header and set the api key to its text
      // content.
      String apikey = ((Element) header.getObject()).getTextContent();

      // Output the api key.
      System.err.println("API Key = " + apikey);


	}

}
