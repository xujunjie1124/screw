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

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

/**
 * 电子优惠劵
 * @author 须俊杰
 * @version 1.0 2013-1-7
 */
public class Coupon implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8570492557760886987L;
	/**
	 * 券编号
	 */
	private String id;

	/**
	 * 券密码
	 */
	private String key;
	/**
	 * 券类型：东券、京券(京券为0，东券为1)
	 */
	private int couponType;
	/**
	 * 电子券、实体券
	 */
	private int couponStyle;
	/**
	 * 优惠金额
	 */
	private BigDecimal discount;
	/**
	 * 订单金额最小限制
	 */
	private BigDecimal quota;

	/**
	 * 开始有效时间
	 */
	private String timeBegin;
	/**
	 * 结束时间
	 */
	private String timeEnd;

	/**
	 * 批次
	 */
	private int pici;
	/**
	 * 是否可用
	 */
	private boolean canUsed;
	/**
	 * 是否当前已经在用
	 */
	private boolean isUsed;

	private int state;

	/**
	 * 特殊标签
	 */
	private List<Integer> tags;

	/**
	 * 优惠券实际抵扣优惠金额
	 */
	private BigDecimal discountCurrentUsed;

	/**
	 * 优惠券限制类型 参看 CouponLimitTypeDict 0: 不限品类 1: 限品类 2: 限店铺
	 */
	private int couponLimitType;

	/**
	 * 店铺券对应的商家ID
	 */
	private int vendorId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getCouponType() {
		return couponType;
	}

	public void setCouponType(int couponType) {
		this.couponType = couponType;
	}

	public int getCouponStyle() {
		return couponStyle;
	}

	public void setCouponStyle(int couponStyle) {
		this.couponStyle = couponStyle;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getQuota() {
		return quota;
	}

	public void setQuota(BigDecimal quota) {
		this.quota = quota;
	}

	public int getPici() {
		return pici;
	}

	public void setPici(int pici) {
		this.pici = pici;
	}

	public boolean isCanUsed() {
		return canUsed;
	}

	public void setCanUsed(boolean canUsed) {
		this.canUsed = canUsed;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<Integer> getTags() {
		return tags;
	}

	public void setTags(List<Integer> tags) {
		this.tags = tags;
	}

	public String getTimeBegin() {
		return timeBegin;
	}

	public void setTimeBegin(String timeBegin) {
		this.timeBegin = timeBegin;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public BigDecimal getDiscountCurrentUsed() {
		return discountCurrentUsed;
	}

	public void setDiscountCurrentUsed(BigDecimal discountCurrentUsed) {
		this.discountCurrentUsed = discountCurrentUsed;
	}

	public int getCouponLimitType() {
		return couponLimitType;
	}

	public void setCouponLimitType(int couponLimitType) {
		this.couponLimitType = couponLimitType;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public static class SortCouponByType implements Comparator<Coupon> {

		@Override
		public int compare(Coupon c1, Coupon c2) {

			return Integer.valueOf(c2.couponLimitType).compareTo(
					Integer.valueOf(c1.couponLimitType));
		}

	}

}
