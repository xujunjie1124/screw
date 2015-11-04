package com.jd.ofc.model.order;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单信息
 * @author 须俊杰
 * @version 1.0 2013-1-23
 */
public class Order {

	/**
	 * 订单ID（内部用的自增）
	 */
	private long orderId;
	
	/**
	 * 参阅DictService.Model.OrderType
	 */
    private int orderType;
	/**
	 * 会员价,即优惠前的总金额
	 */
	private BigDecimal price;
	/**
	 * 返现金
	 */
	private BigDecimal rePrice;
	/**
	 * 优惠金额 这是一个基础值，促销价=会员价-优惠金额
	 */
	private BigDecimal discount;
	/**
	 * 优惠券的优惠金额
	 */
	private BigDecimal couponDiscount;
	/**
	 * 总运费
	 */
	private BigDecimal totalFee;
	/**
	 * 电信积分优惠
	 */
	private BigDecimal discountTelecomIntegral;
	/**
	 * 礼品卡优惠
	 */
	private BigDecimal discountLipinka;
	/**
	 * 订单使用的余额
	 */
	private BigDecimal moneyBalance;
	/**
	 * 手机红包优惠
	 */
	private BigDecimal discountMobile;
	/**
	 * 实际支付金额(以后再定)
	 */
	private BigDecimal payMoney;	
	/**
	 * 能效补贴优惠
	 */
	private BigDecimal ElePowDiscount;
	/**
	 * 电子券选择
	 */
	protected Coupon[] theCoupons;
	/**
	 * 礼品卡
	 */
	protected CouponLPK[] theLipinkas;
	/**
	 * 父订单ID
	 */
	private long parentId;

    /**
     * 积分数
     */
	private int jiFenCount;
    
    /**
     * 积分金额
     */
	private BigDecimal jiFenDiscountMoney;
    
	/**
	 * EPT优惠金额
	 */
	private BigDecimal couponCodeDiscount;
	
	/**
     * EPT优惠码
     */
    private String couponCode;
    
	/**
	 * 购物车
	 */
	private Cart cart;
	/**
	 * 运费列表
	 */
	private List<FreightEntity> freightInfo;
	
	/**
     * 订单扩展信息
     */
    private ExtInfo[] theExt;
	
    /**
     * 拆分类型
     */
	private int splitType;
	
	/**
	 * SendPay
	 */
	private String sendPay;
    
	/**
	 * 以旧换新
	 */
	private List<LaptopReplacement> laptopReplacementList;
	
	/**
	 * 京豆数
	 */
	private Integer jingDouCount;

	/**
	 * 京豆比率
	 */
	private Integer jingDouRate;
	/**
	 * 直接父单
	 */
	private long dParentId;
	
	/**
	 * 下单人的帐号
	 */
	public String pin;
	
	/**
	 * 扩展标签
	 */
    private ExtTagPair[] theExtTags;
	  
	public List<FreightEntity> getFreightInfo() {
		return freightInfo;
	}

	public void setFreightInfo(List<FreightEntity> freightInfo) {
		this.freightInfo = freightInfo;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

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

	public BigDecimal getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

	public BigDecimal getDiscountTelecomIntegral() {
		return discountTelecomIntegral;
	}

	public void setDiscountTelecomIntegral(BigDecimal discountTelecomIntegral) {
		this.discountTelecomIntegral = discountTelecomIntegral;
	}

	public BigDecimal getDiscountLipinka() {
		return discountLipinka;
	}

	public void setDiscountLipinka(BigDecimal discountLipinka) {
		this.discountLipinka = discountLipinka;
	}

	public BigDecimal getMoneyBalance() {
		return moneyBalance;
	}

	public void setMoneyBalance(BigDecimal moneyBalance) {
		this.moneyBalance = moneyBalance;
	}

	public BigDecimal getDiscountMobile() {
		return discountMobile;
	}

	public void setDiscountMobile(BigDecimal discountMobile) {
		this.discountMobile = discountMobile;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public BigDecimal getElePowDiscount() {
		return ElePowDiscount;
	}

	public void setElePowDiscount(BigDecimal elePowDiscount) {
		ElePowDiscount = elePowDiscount;
	}

	public ExtInfo[] getTheExt() {
		return theExt;
	}

	public void setTheExt(ExtInfo[] theExt) {
		this.theExt = theExt;
	}

	public Coupon[] getTheCoupons() {
		return theCoupons;
	}

	public void setTheCoupons(Coupon[] theCoupons) {
		this.theCoupons = theCoupons;
	}

	public CouponLPK[] getTheLipinkas() {
		return theLipinkas;
	}

	public void setTheLipinkas(CouponLPK[] theLipinkas) {
		this.theLipinkas = theLipinkas;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	
	public int getJiFenCount() {
		return jiFenCount;
	}

	public void setJiFenCount(int jiFenCount) {
		this.jiFenCount = jiFenCount;
	}

	public int getSplitType() {
		return splitType;
	}

	public void setSplitType(int splitType) {
		this.splitType = splitType;
	}

	public String getSendPay() {
		return sendPay;
	}

	public void setSendPay(String sendPay) {
		this.sendPay = sendPay;
	}

	public List<LaptopReplacement> getLaptopReplacementList() {
		return laptopReplacementList;
	}

	public void setLaptopReplacementList(
			List<LaptopReplacement> laptopReplacementList) {
		this.laptopReplacementList = laptopReplacementList;
	}

	

	public BigDecimal getJiFenDiscountMoney() {
		return jiFenDiscountMoney;
	}

	public Integer getJingDouCount() {
        return jingDouCount;
    }

    public void setJingDouCount(Integer jingDouCount) {
        this.jingDouCount = jingDouCount;
    }

    public Integer getJingDouRate() {
        return jingDouRate;
    }

    public void setJingDouRate(Integer jingDouRate) {
        this.jingDouRate = jingDouRate;
    }

    public void setJiFenDiscountMoney(BigDecimal jiFenDiscountMoney) {
		this.jiFenDiscountMoney = jiFenDiscountMoney;
	}

	public BigDecimal getCouponCodeDiscount() {
		return couponCodeDiscount;
	}

	public void setCouponCodeDiscount(BigDecimal couponCodeDiscount) {
		this.couponCodeDiscount = couponCodeDiscount;
	}
    
	public long getdParentId() {
		return dParentId;
	}

	public void setdParentId(long dParentId) {
		this.dParentId = dParentId;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

    public ExtTagPair[] getTheExtTags() {
        return theExtTags;
    }

    public void setTheExtTags(ExtTagPair[] theExtTags) {
        this.theExtTags = theExtTags;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
}
