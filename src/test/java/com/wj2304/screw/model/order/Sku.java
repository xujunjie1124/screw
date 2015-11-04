package com.wj2304.screw.model.order;

import java.io.Serializable;
import java.math.BigDecimal;

public class Sku extends YBProduct implements Serializable {

	private static final long serialVersionUID = 3883874708962365503L;

	/**
	 * UUID
	 */
	private String uuid;

	/**
	 * 京东价
	 */
	private BigDecimal price;
	/**
	 * 优惠
	 */
	private BigDecimal discount;

	/**
	 * 返现金
	 */
	private BigDecimal reprice;

	/**
	 * 购买数量
	 */
	private int num;

	private ExtTagPair[] theExtTags;
	
	/**
	* 赠品拆分价格
	*/
	private BigDecimal giftSplitPrice;
	
	/**
     *  机构(商家)ID
     */
    private int shopId;
	
	/**
	* 促销id
	*/
	private Long promoId;
	
	/**
     *   商家类型
     */
    private int shopType=3;
	
	/**
	 * 商品类型(Ocs内部使用，不序列化)
	 */
	private boolean mainSkuFlag = false;
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getReprice() {
		return reprice;
	}

	public void setReprice(BigDecimal reprice) {
		this.reprice = reprice;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ExtTagPair[] getTheExtTags() {
		return theExtTags;
	}

	public void setTheExtTags(ExtTagPair[] theExtTags) {
		this.theExtTags = theExtTags;
	}

	public BigDecimal getGiftSplitPrice() {
		return giftSplitPrice;
	}

	public void setGiftSplitPrice(BigDecimal giftSplitPrice) {
		this.giftSplitPrice = giftSplitPrice;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public Long getPromoId() {
		return promoId;
	}

	public void setPromoId(Long promoId) {
		this.promoId = promoId;
	}

	public int getShopType() {
		return shopType;
	}

	public void setShopType(int shopType) {
		this.shopType = shopType;
	}

	public boolean isMainSkuFlag() {
		return mainSkuFlag;
	}

	public void setMainSkuFlag(boolean mainSkuFlag) {
		this.mainSkuFlag = mainSkuFlag;
	}
}
