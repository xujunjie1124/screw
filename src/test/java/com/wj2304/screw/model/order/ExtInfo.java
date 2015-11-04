/*
 * COPYRIGHT. www.360buy.com 2011. ALL RIGHTS RESERVED.
 * 
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of www.360buy.com Holdings plc.
 */
package com.wj2304.screw.model.order;


/**
 * ExtInfo 扩展信息
 * @author 须俊杰
 * @version 1.0 2013-1-23
 */
public class ExtInfo implements java.io.Serializable {

	private static final long serialVersionUID = 2966120628427460507L;

	/**
	 * 订单号
	 */
	private long orderId;

	/**
	 * 商品编号
	 */
	private int skuId;

	/**
	 * 类型
	 */
	private int typeId;

	/**
	 * 序列化信息
	 */
	private String xml;

	private int state;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
