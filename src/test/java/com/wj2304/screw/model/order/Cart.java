package com.wj2304.screw.model.order;

import java.math.BigDecimal;

/**
 * 购物车对象
 * @author 须俊杰
 * @version 1.0 2013-1-8
 */
public class Cart {
	/**
	 * 所属订单ID
	 */
	private Long orderId;
	/**
	 * 单品数组
	 */
	private Sku[] theSkus;
	/**
	 * 赠品数组
	 */
	private Suit[] theGifts;
	/**
	 * 套装数组
	 */
	private Suit[] thePacks;
	/**
	 * 总的会员价
	 */
	private BigDecimal totalPrice;

	/**
	 * 总的优惠差价
	 */
	private BigDecimal totalDiscount;
	
	/**
	 * 返现金
	 */
	private BigDecimal totalRePrice;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Sku[] getTheSkus() {
		return theSkus;
	}

	public void setTheSkus(Sku[] theSkus) {
		this.theSkus = theSkus;
	}

	public Suit[] getTheGifts() {
		return theGifts;
	}

	public void setTheGifts(Suit[] theGifts) {
		this.theGifts = theGifts;
	}

	public Suit[] getThePacks() {
		return thePacks;
	}

	public void setThePacks(Suit[] thePacks) {
		this.thePacks = thePacks;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(BigDecimal totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public BigDecimal getTotalRePrice() {
		return totalRePrice;
	}

	public void setTotalRePrice(BigDecimal totalRePrice) {
		this.totalRePrice = totalRePrice;
	}

}
