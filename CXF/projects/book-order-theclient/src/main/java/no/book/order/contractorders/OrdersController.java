package no.book.order.contractorders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookcontract.schema.order.ObjectFactory;
import com.bookcontract.schema.order.OrderInquiryResponseType;
import com.bookcontract.schema.order.OrderInquiryType;
import com.bookcontract.service.orders.Orders;

@Controller("/processOrderPlacement")
public class OrdersController {

	// Add the Orders interface as a member of the controller
	@Autowired
	private Orders orders;
   
   @RequestMapping(method = RequestMethod.GET)
   public String processOrderPlacement(ModelMap model) throws Exception {
	   // Add the creation of an OrderInquiry request type and populate it
	   OrderInquiryType orderInquiry = new ObjectFactory()
	            .createOrderInquiryType();
      orderInquiry.setAccountId(1234);
      orderInquiry.setEan13(1234567890123L);
      orderInquiry.setOrderQuantity(2);
      orderInquiry.setUniqueOrderId(999);
  
      // Call the orders web service  
      OrderInquiryResponseType response = orders
              .processOrderPlacement(orderInquiry);    
  
      // Set the order status on the model from the web service response.
      model.addAttribute(
    		  "orderStatus", 
    		  response.getOrder().getOrderStatus());
      
      // View we are returning to, in this case processOrderPlacement.jsp 
      return "processOrderPlacement";
   }
}
