package com.jd.ofc.model.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Suit 套装
 * 
 * @author 须俊杰
 * @version 1.0 2013-1-7
 */
public class Suit implements java.io.Serializable {

	private static final long serialVersionUID = 5687943896104661781L;

	/**
	 * 默认数量是1
	 */
	public Suit() {
		this.num = 1;
	}

	/**
	 * 自定义id和num
	 * @param id
	 * @param num
	 */
	public Suit(long id, int num) {
		this.id = id;
		this.num = num;
	}

	/**
	 * 主商品，用在赠品中
	 */
	private Sku mainSKU;

	/**
	 * 商品列表
	 */
	private List<Sku> theSkus;

	/**
	 * 套装中的赠品
	 */
	private List<Sku> gifts;

	/**
	 * 套装扩展标签
	 */
	private List<Integer> extTags = new ArrayList<Integer>();

	/**
	 * 编号
	 */
	private long id;

	/**
	 * 套装名称
	 */
	private String name;

	/**
	 * 会员价(京东价)
	 */
	private BigDecimal price;

	private BigDecimal discount;
	/**
	 * 购买套装数量
	 */
	private int num;

	/**
	 * 返现
	 */
	private BigDecimal rePrice;

	/**
	 * 套装类型（6:套装;10:满返满送）
	 */
	private int suitType;

	private int type;

	/**
	 * 返现金
	 */
	private BigDecimal money;

	public Sku getMainSKU() {
		return mainSKU;
	}

	public void setMainSKU(Sku mainSKU) {
		this.mainSKU = mainSKU;
	}

	public List<Sku> getTheSkus() {
		return theSkus;
	}

	public void setTheSkus(List<Sku> theSkus) {
		this.theSkus = theSkus;
	}

	public List<Sku> getGifts() {
		return gifts;
	}

	public void setGifts(List<Sku> gifts) {
		this.gifts = gifts;
	}

	public List<Integer> getExtTags() {
		return extTags;
	}

	public void setExtTags(List<Integer> extTags) {
		this.extTags = extTags;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public BigDecimal getRePrice() {
		return rePrice;
	}

	public void setRePrice(BigDecimal rePrice) {
		this.rePrice = rePrice;
	}

	public int getSuitType() {
		return suitType;
	}

	public void setSuitType(int suitType) {
		this.suitType = suitType;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
