package com.logo.eshow.bean.query;

/**
 * 基础查询Bean
 * 
 * @author leida
 * 
 */
public class BaseQueryBean {
	public String order;

	public Boolean desc;

	/**
	 * 每页记录数
	 */
	public int pagesize = 10;

	/**
	 * 开始数目
	 */
	public int begin = 1;

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Boolean getDesc() {
		return desc;
	}

	public void setDesc(Boolean desc) {
		this.desc = desc;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	/**
	 * @return int 页面偏移量
	 */
	public int getOffset() {
		try {
			new Integer(begin);
			return (begin - 1) * pagesize;
		} catch (Exception e) {
			return 0;
		}
	}
}