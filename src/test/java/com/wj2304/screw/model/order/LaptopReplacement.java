package com.wj2304.screw.model.order;

import java.math.BigDecimal;

/**
 * 以旧换新
 */
public class LaptopReplacement implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2297816177820614550L;

	private int skuId;
	
	private BigDecimal laptopReplacementDiscount;
	
	private int num;

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public BigDecimal getLaptopReplacementDiscount() {
		return laptopReplacementDiscount;
	}

	public void setLaptopReplacementDiscount(BigDecimal laptopReplacementDiscount) {
		this.laptopReplacementDiscount = laptopReplacementDiscount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
