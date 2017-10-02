package com.bookcontract.service.orders;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.1.13
 * 2017-10-02T14:51:28.843+02:00
 * Generated source version: 3.1.13
 * 
 */
@WebService(targetNamespace = "http://www.bookcontract.com/service/Orders/", name = "Orders")
@XmlSeeAlso({com.bookcontract.schema.order.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Orders {

    @WebMethod(operationName = "ProcessOrderPlacement", action = "http://www.bookcontract.com/service/Orders/ProcessOrderPlacement")
    @WebResult(name = "orderInquiryResponse", targetNamespace = "http://www.bookcontract.com/schema/Order", partName = "orderInquiryResponse")
    public com.bookcontract.schema.order.OrderInquiryResponseType processOrderPlacement(
        @WebParam(partName = "orderInquiry", name = "orderInquiry", targetNamespace = "http://www.bookcontract.com/schema/Order")
        com.bookcontract.schema.order.OrderInquiryType orderInquiry
    );
}
