package com.wj2304.screw.model.order;

import java.math.BigDecimal;

/**
 * 能效补贴
 * 
 * @author 须俊杰
 * @version 1.0 2013-1-23
 */
public class EfficiencySubsidyInfo {

	/* 补贴金额 */
	private BigDecimal subsidy;

	/* 厂家名称 */
	private String brandName;

	/* SN 码 长度 */
	private Integer snLength;

	/* 购买人类型 1个人, 2企业 */
	private Integer buyerType;

	/* 购买人姓名, 或者企业名称 */
	private String buyerName;

	/* 购买人身份证号, 或者企业营业执照号码 */
	private String buyerIDNumber;

	/* 是否能效补贴 */
	private Boolean isEnergySaving;

	public BigDecimal getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(BigDecimal subsidy) {
		this.subsidy = subsidy;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getSnLength() {
		return snLength;
	}

	public void setSnLength(Integer snLength) {
		this.snLength = snLength;
	}

	public Integer getBuyerType() {
		return buyerType;
	}

	public void setBuyerType(Integer buyerType) {
		this.buyerType = buyerType;
	}


	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerIDNumber() {
		return buyerIDNumber;
	}

	public void setBuyerIDNumber(String buyerIDNumber) {
		this.buyerIDNumber = buyerIDNumber;
	}

	public Boolean getIsEnergySaving() {
		return isEnergySaving;
	}

	public void setIsEnergySaving(Boolean isEnergySaving) {
		this.isEnergySaving = isEnergySaving;
	}

}
