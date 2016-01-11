package com.percyvega.cxf.orders;

import com.percyvega.cxf.schema.order.OrderInquiryResponseType;
import com.percyvega.cxf.schema.order.OrderInquiryType;
import com.percyvega.cxf.service.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;

/**
 * Created by percy on 1/10/2016.
 */
@WebService(portName = "OrdersSOAP",
        serviceName = "Orders",
        endpointInterface = "com.percyvega.cxf.service.orders.Orders",
        targetNamespace = "http://cxf.percyvega.com/service/Orders")
public class DefaultOrdersEndpoint implements Orders {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderInquiryResponseType processOrderPlacement(OrderInquiryType orderInquiry) {

        OrderInquiryResponseType responseType = orderService.processOrder(orderInquiry.getUniqueOrderId(),
                orderInquiry.getOrderQuantity(),
                orderInquiry.getAccountId(),
                orderInquiry.getEan13());

        return responseType;
    }
}
