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


/**
 * 扩展标记对
 * @author 须俊杰
 * @version 1.0 2013-1-25
 */
public class ExtTagPair implements java.io.Serializable {

	private static final long serialVersionUID = -5605357996702286214L;
	/**
	 * 键
	 */
	private String key;
	/**
	 * 值
	 */
	private String val;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
}
