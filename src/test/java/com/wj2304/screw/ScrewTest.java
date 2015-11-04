package com.wj2304.screw;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map.Entry;

import junit.framework.Assert;

import org.junit.Test;

import com.wj2304.screw.Screw;
import com.wj2304.screw.common.utils.SafeSimpleDateFormat;
import com.wj2304.screw.common.utils.StringUtils;
import com.wj2304.screw.model.OrderSplitInfoMessage;
import com.wj2304.screw.model.bookstore.Book;
import com.wj2304.screw.model.bookstore.BookStore;
import com.wj2304.screw.model.bookstore.User;
import com.wj2304.screw.model.order.Order;

public class ScrewTest {

    @Test
    public void testFromXML() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream(
                "/thirdparty/bookStore.xml");
        String xml = StringUtils.inputStream2String(inputStream);
        BookStore bookStore = Screw.fromXML(xml, BookStore.class);

        Assert.assertEquals("须俊杰", bookStore.getKeeper());
        Assert.assertEquals(null, bookStore.getAddress());
        Assert.assertEquals(true, bookStore.getIsOk().booleanValue());
        
        for (Book book : bookStore.getBooks()) {
            if (book.getId() == 11561445) {
                Assert.assertEquals("火车头 [3-6岁]", book.getTitle());
                Assert.assertEquals("布莱恩·弗洛卡", book.getAuthor());
                Assert.assertEquals("2014-12-01", SafeSimpleDateFormat.format(book.getPublishDate(),"yyyy-MM-dd"));
                Assert.assertEquals(new BigDecimal("23.80"), book.getPrice());
            }
            if (book.getId() == 11452840) {
                Assert.assertEquals("东野圭吾：解忧杂货店 [ナミヤ雑貨店の奇蹟]", book.getTitle());
                Assert.assertEquals("东野圭吾", book.getAuthor());
                Assert.assertEquals("2014-08-01", SafeSimpleDateFormat.format(book.getPublishDate(),"yyyy-MM-dd"));
                Assert.assertEquals(new BigDecimal("27.80"), book.getPrice());
            }
            if (book.getId() == 11573108) {
                Assert.assertEquals("如果世上不再有猫", book.getTitle());
                Assert.assertEquals("川村元气", book.getAuthor());
                Assert.assertEquals("2014-01-01", SafeSimpleDateFormat.format(book.getPublishDate(),"yyyy-MM-dd"));
                Assert.assertEquals(new BigDecimal("25.80"), book.getPrice());
            }
        }
        
        for(User user : bookStore.getUsers()){
            if (user.getId() == 1) {
                Assert.assertEquals("张三", user.getName());
                Assert.assertEquals(23, user.getAge().longValue());
                Assert.assertEquals(65.0f, user.getWeight());
                Assert.assertEquals(178.0d, user.getHeight());
            }
            if (user.getId() == 2) {
                Assert.assertEquals("李四", user.getName());
                Assert.assertEquals(24, user.getAge().longValue());
                Assert.assertEquals(75.0f, user.getWeight());
                Assert.assertEquals(188.0d, user.getHeight());
            }
            if (user.getId() == 3) {
                Assert.assertEquals("王五", user.getName());
                Assert.assertEquals(25, user.getAge().longValue());
                Assert.assertEquals(56.0f, user.getWeight());
                Assert.assertEquals(172.0d, user.getHeight());
            }
        }
        
        for(Entry<String, User> entry : bookStore.getUserMap().entrySet()){
            String id = entry.getKey();
            User user = entry.getValue();
            if (id.equals("4")) {
                Assert.assertEquals("王二小", user.getName());
                Assert.assertEquals(15, user.getAge().longValue());
                Assert.assertEquals(50.0f, user.getWeight());
                Assert.assertEquals(192.0d, user.getHeight());
            }
            if (user.getId() == 5) {
                Assert.assertEquals("周扒皮", user.getName());
                Assert.assertEquals(45, user.getAge().longValue());
                Assert.assertEquals(59.0f, user.getWeight());
                Assert.assertEquals(132.0d, user.getHeight());
            }
        }
    }

    @Test
    public void testFromXMLForOrder() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream(
                "/thirdparty/7853946887-order.xml");
        String xml = StringUtils.inputStream2String(inputStream);
        Order order = Screw.fromXML(xml, Order.class);

        System.out.println(order.getDiscount());

        Assert.assertEquals(new BigDecimal("8.70"), order.getDiscount());
    }

    @Test
    public void testFromXMLForMessage() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream(
                "/thirdparty/message_8078707034.xml");
        String xml = StringUtils.inputStream2String(inputStream);
        OrderSplitInfoMessage message = Screw.fromXML(xml,
                OrderSplitInfoMessage.class);

        Assert.assertEquals(8078707034l, message.getRelatedId());
    }
}
