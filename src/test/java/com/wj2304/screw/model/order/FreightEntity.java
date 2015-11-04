package com.wj2304.screw.model.order;

import java.math.BigDecimal;

/**
 * 延保商品
 *
 * @author 须俊杰
 */
public class FreightEntity {
    
    /**
     * 商品编号
     */
	private int wid;
	
	/**
	 * 数量
	 */
	private int num;
	
	/**
	 * 金额
	 */
	private BigDecimal needFee;
	
	/**
	 * 类型
	 */
	private int type;
	
	/**
	 * 商家编号
	 */
    private int vendorId;  //商家ID

	/**
	 * 初始化，默认规则
	 */
	public FreightEntity(){
		this.needFee = BigDecimal.ZERO;
	}
	
	/**
     * 初始化，指定商品、数量、金额
     */
	public FreightEntity(int wid, int num, BigDecimal needFee) {
		this.wid = wid;
		this.num = num;
		this.needFee = needFee;
	}
	
	/**
     * 初始化，指定商品、数量、金额、类型
     */
    public FreightEntity(int wid, int num, BigDecimal needFee, int type) {
		this.wid = wid;
		this.num = num;
		this.needFee = needFee;
		this.type = type;
	}
    
    /**
     * 初始化，指定商品、数量、金额、类型、商家
     */
    public FreightEntity(int wid, int num, BigDecimal needFee, int type, int vendorId) {
		this.wid = wid;
		this.num = num;
		this.needFee = needFee;
		this.type = type;
		this.vendorId = vendorId;
	}
	
    /**
     * 初始化，指定金额、类型
     */
    public FreightEntity(BigDecimal needFee, int type) {
    	this.needFee = needFee;
    	this.type = type;
    }

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public BigDecimal getNeedFee() {
		return needFee;
	}

	public void setNeedFee(BigDecimal needFee) {
		this.needFee = needFee;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
    
    
}
