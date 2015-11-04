/*
 * COPYRIGHT. www.360buy.com 2011. ALL RIGHTS RESERVED.
 * 
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of www.360buy.com Holdings plc.
 */
package com.jd.ofc.model.order;

import java.io.Serializable;

/**
 * Product 产品
 * @author 须俊杰
 * @version 1.0 2013-1-8
 */
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 商品唯一标识
	 */
	private String uuid;
	/**
	 * 产品编号
	 */
	private int id;
	/**
	 * 所属分类
	 */
	private int cid;
	/**
	 * 产品名称
	 */
	private String name;

	/**
	 * 分类2
	 */
	private int cid2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCid2() {
		return cid2;
	}

	public void setCid2(int cid2) {
		this.cid2 = cid2;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
