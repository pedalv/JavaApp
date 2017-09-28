package no.book.order.contractorders;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookcontract.schema.order.AccountType;
import com.bookcontract.schema.order.ObjectFactory;
import com.bookcontract.schema.order.OrderInquiryResponseType;
import com.bookcontract.schema.order.OrderInquiryType;
import com.bookcontract.service.orders.Orders;

@WebService(portName = "OrdersSOAP", serviceName = "Orders",
endpointInterface = "com.bookcontract.service.orders.Orders",
targetNamespace = "http://www.bookcontract.com/service/Orders/")
public class DefaultOrdersEndpoint implements Orders {

	@Autowired
	private OrderService orderService;
	
	@Override
	public OrderInquiryResponseType processOrderPlacement(
			OrderInquiryType orderInquiry) {
		
		//return null;
		/*
		ObjectFactory factory = new ObjectFactory();
		OrderInquiryResponseType response = factory
				.createOrderInquiryResponseType();
		AccountType account = factory.createAccountType();
		account.setAccountId(1);
		response.setAccount(account);
		return response;*/
		
		OrderInquiryResponseType response = orderService.processOrder(
				orderInquiry.getUniqueOrderId(),
				orderInquiry.getOrderQuantity(),
				orderInquiry.getUniqueOrderId(),
				orderInquiry.getEan13());
		
		return  response;
				
		
		
	}

}