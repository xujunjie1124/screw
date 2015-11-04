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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * YBProduct 延保产品
 * @author 须俊杰
 * @version 1.0 2013-1-8
 */
public class YBProduct extends Product implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 相关的延保产品ID
	 */
	private int ybChildId;
	/**
	 * 相关的延保产品数量
	 */
	private int ybChildNum;
	/**
	 * 是否为延保产品
	 */
	private boolean isYb;

	//新增延保节点
    /**
     *  延保产品信息
     */
    private List<YBEntity> ybEntitys = new ArrayList<YBEntity>();
   
	public List<YBEntity> getYbEntitys() {
		return ybEntitys;
	}

	public void setYbEntitys(List<YBEntity> ybEntitys) {
		this.ybEntitys = ybEntitys;
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

	public boolean isIsYb() {
		return isYb;
	}

	public void setIsYb(boolean isYb) {
		this.isYb = isYb;
	}

}
