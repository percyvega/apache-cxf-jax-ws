package com.percyvega.cxf.orders;

import com.percyvega.cxf.schema.order.OrderInquiryResponseType;

/**
 * Created by percy on 1/10/2016.
 */
public interface OrderService {

    public OrderInquiryResponseType processOrder(int uniqueOrderId, int orderQuantity, int accountId, long ean13);

}
