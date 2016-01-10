package com.percyvega.cxf.orders;

import com.percyvega.cxf.schema.order.*;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by percy on 1/10/2016.
 */
@Service
public class DefaultOrderService implements OrderService {

    @Override
    public OrderInquiryResponseType processOrder(int uniqueOrderId, int orderQuantity, int accountId, long ean13) {
        ObjectFactory objectFactory = new ObjectFactory();

        AccountType account = objectFactory.createAccountType();
        account.setAccountId(accountId);

        OrderInquiryResponseType response = objectFactory.createOrderInquiryResponseType();
        response.setAccount(account);

        BookType book = objectFactory.createBookType();
        book.setEan13(ean13);
        book.setTitle("A CXF Book");

        OrderItemType orderItem = objectFactory.createOrderItemType();
        orderItem.setBook(book);

        try {

            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(new Date(System.currentTimeMillis()));
            XMLGregorianCalendar estimatedShippingDate =
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
            orderItem.setExpectedShippingDate(estimatedShippingDate);
            orderItem.setLineNumber(Integer.valueOf(1));
            orderItem.setPrice(new BigDecimal(5));
            orderItem.setQuantityShipped(orderQuantity);

        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        OrderType order = objectFactory.createOrderType();
        order.setOrderStatus(OrderStatusType.READY);
        order.getOrderItems().add(orderItem);

        response.setOrder(order);

        return response;
    }
}
