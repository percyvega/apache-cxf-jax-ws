package com.percyvega.cxf.orders;

import com.percyvega.cxf.schema.order.AccountType;
import com.percyvega.cxf.schema.order.ObjectFactory;
import com.percyvega.cxf.schema.order.OrderInquiryResponseType;
import com.percyvega.cxf.schema.order.OrderInquiryType;
import com.percyvega.cxf.service.orders.Orders;

import javax.jws.WebService;

/**
 * Created by percy on 1/10/2016.
 */
@WebService(portName = "OrdersSOAP",
        serviceName = "Orders",
        endpointInterface = "com.percyvega.cxf.service.orders.Orders",
        targetNamespace = "http://cxf.percyvega.com/service/Orders")
public class DefaultOrdersEndpoint implements Orders {

    @Override
    public OrderInquiryResponseType processOrderPlacement(OrderInquiryType orderInquiry) {

        System.out.println(orderInquiry.getUniqueOrderId());
        System.out.println(orderInquiry.getOrderQuantity());
        System.out.println(orderInquiry.getAccountId());
        System.out.println(orderInquiry.getEan13());

        ObjectFactory objectFactory = new ObjectFactory();

        AccountType accountType = objectFactory.createAccountType();
        accountType.setAccountId(orderInquiry.getAccountId());

        OrderInquiryResponseType orderInquiryResponseType = objectFactory.createOrderInquiryResponseType();
        orderInquiryResponseType.setAccount(accountType);

        return orderInquiryResponseType;
    }
}
