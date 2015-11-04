package com.jd.ofc.model.order;

import java.math.BigDecimal;

/**
 * 金额明细
 * 
 * @author 须俊杰
 * @version 1.0 2013-1-8
 */
public class AmountDetail {
	/* UUID */
	private String uuid;
	/* 商品编号 */
	private Integer skuId;
	/* 商品的会员价 */
	private BigDecimal price;
	/* 返现金额 */
	private BigDecimal rePrice;
	/* 优惠金额 */
	private BigDecimal discount;
	/* 优惠卷总金额 */
	private BigDecimal couponDiscount;
	/* 基础运费 */
	private BigDecimal baseFree;
	/* 偏远地区运费 */
	private BigDecimal remoteAreasFree;
	/* 礼品卡总优惠 */
	private BigDecimal giftCardDiscount;
	/* 订单使用余额 */
	private BigDecimal moneyBalance;
	/* 手机红包 */
	private BigDecimal mobileDiscount;
	/* 订单的实付金额（即财务对账金额） */
	private BigDecimal payMoney;
	/* 节能补贴金额 */
	private BigDecimal energySubsidy;
	/* 满减金额 */
	private BigDecimal moneyOfSuit;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getRePrice() {
		return rePrice;
	}

	public void setRePrice(BigDecimal rePrice) {
		this.rePrice = rePrice;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(BigDecimal couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	public BigDecimal getBaseFree() {
		return baseFree;
	}

	public void setBaseFree(BigDecimal baseFree) {
		this.baseFree = baseFree;
	}

	public BigDecimal getRemoteAreasFree() {
		return remoteAreasFree;
	}

	public void setRemoteAreasFree(BigDecimal remoteAreasFree) {
		this.remoteAreasFree = remoteAreasFree;
	}

	public BigDecimal getGiftCardDiscount() {
		return giftCardDiscount;
	}

	public void setGiftCardDiscount(BigDecimal giftCardDiscount) {
		this.giftCardDiscount = giftCardDiscount;
	}

	public BigDecimal getMoneyBalance() {
		return moneyBalance;
	}

	public void setMoneyBalance(BigDecimal moneyBalance) {
		this.moneyBalance = moneyBalance;
	}

	public BigDecimal getMobileDiscount() {
		return mobileDiscount;
	}

	public void setMobileDiscount(BigDecimal mobileDiscount) {
		this.mobileDiscount = mobileDiscount;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}
	public BigDecimal getMoneyOfSuit() {
		return moneyOfSuit;
	}

	public void setMoneyOfSuit(BigDecimal moneyOfSuit) {
		this.moneyOfSuit = moneyOfSuit;
	}

	public BigDecimal getEnergySubsidy() {
		return energySubsidy;
	}

	public void setEnergySubsidy(BigDecimal energySubsidy) {
		this.energySubsidy = energySubsidy;
	}

	public Integer getSkuId() {
		return skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
