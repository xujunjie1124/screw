package com.wj2304.screw.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wj2304.screw.annotations.ScrewAlias;
import com.wj2304.screw.model.order.Order;

public class OrderSplitInfoMessage {
    /* 消息类型 */
    private int messageType;

    /* 消息创建时间 */
    private Date creationTime;

    /* 订单号（未拆分时为原订单号；拆分时为父订单号） */
    @ScrewAlias("RelatedId")
    private long relatedId;

    /* 用户昵称 */
    private String userName;

	/* 源订单 */
    private Order order;

    /* 拆分后的订单 */
    private List<Order> children = new ArrayList<Order>();

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    
    public List<Order> getChildren() {
        return children;
    }

    public void setChildren(List<Order> children) {
        this.children = children;
    }

    public long getRelatedId() {
		return relatedId;
	}

	public void setRelatedId(long relatedId) {
		this.relatedId = relatedId;
	}

}
