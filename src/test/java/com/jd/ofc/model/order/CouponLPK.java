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

import java.math.BigDecimal;

/**
 * 礼品卡
 * @author 须俊杰
 * @version 1.0 2013-1-7
 */
public class CouponLPK extends Coupon {

	private static final long serialVersionUID = 1306760389850718479L;

	/**
	 * 已经使用的优惠
	 */
	private BigDecimal discountUsed;
	/**
	 * 当前订单使用的优惠
	 */
	private BigDecimal discountCurUsed;
	/**
	 * 当前订单绑定的金额
	 */
	private BigDecimal discountBind;
	/**
	 * Coupon所有人
	 */
	private String pin;

	/**
	 * 当前订单是否已经绑定
	 */
	private boolean checked;

	private String rfId;

	private String rfType;

	private int orgId;

	public BigDecimal getLeaveMoney() {
		return (this.getDiscount().subtract(discountUsed).add(discountBind))
				.compareTo(BigDecimal.ZERO) == -1 ? BigDecimal.ZERO : this
				.getDiscount().subtract(discountUsed).add(discountBind);
	}

	public BigDecimal getDiscountUsed() {
		return discountUsed;
	}

	public void setDiscountUsed(BigDecimal discountUsed) {
		this.discountUsed = discountUsed;
	}

	public BigDecimal getDiscountCurUsed() {
		return discountCurUsed;
	}

	public void setDiscountCurUsed(BigDecimal discountCurUsed) {
		this.discountCurUsed = discountCurUsed;
	}

	public BigDecimal getDiscountBind() {
		return discountBind;
	}

	public void setDiscountBind(BigDecimal discountBind) {
		this.discountBind = discountBind;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getRfId() {
		return rfId;
	}

	public void setRfId(String rfId) {
		this.rfId = rfId;
	}

	public String getRfType() {
		return rfType;
	}

	public void setRfType(String rfType) {
		this.rfType = rfType;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
}
