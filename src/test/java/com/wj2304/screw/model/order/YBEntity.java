package com.wj2304.screw.model.order;


public class YBEntity implements java.io.Serializable {

	private static final long serialVersionUID = -4547248967481151494L;
	/**
	 * 相关的延保产品ID
	 */
	private int ybChildId;
	/**
	 * 相关的延保产品数量
	 */
	private int ybChildNum;
	/**
	 * suitId
	 */
	private long suitId;
	
	public long getSuitId() {
		return suitId;
	}

	public void setSuitId(long suitId) {
		this.suitId = suitId;
	}

	public int getYbChildId() {
		return ybChildId;
	}

	public void setYbChildId(int ybChildId) {
		this.ybChildId = ybChildId;
	}

	public int getYbChildNum() {
		return ybChildNum;
	}

	public void setYbChildNum(int ybChildNum) {
		this.ybChildNum = ybChildNum;
	}
}
