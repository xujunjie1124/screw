package com.wj2304.screw.model.order;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 运费劵
 * 
 * @author xkt
 * @version 1.0 2014-9-17
 */
public class FreightCoupon implements Serializable {

	private static final long serialVersionUID = 1082456591118702843L;

	/** 运费劵编号 */
	private String couponId;

	/** 运费劵支持的sku列表 */
	private List<Integer> skuIdList;

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public List<Integer> getSkuIdList() {
		return skuIdList;
	}

	public void setSkuIdList(List<Integer> skuIdList) {
		this.skuIdList = skuIdList;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("couponId", couponId)
				.append("skuIdList", skuIdList).toString();
	}
}
