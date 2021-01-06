package com.yuntu.util;

import java.util.List;

/**
 * 实现分页类
 * @author Lsz
 *
 */
public class PageUtil<T> {
	//五个属性
	private int pageindex=1;//当前页(页码)
	private int pagesize=10;// 页面大小
	private int counts=0;//记录总数
	private int pagecount=0;//总页数
	private List<T> lists;//保存当前页面对象集合
	
	//get set
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
		//在设置总记录时，一并设置总页数
		if(counts>0) {
			pagecount = counts%pagesize==0?(counts/pagesize):((counts/pagesize)+1);
		}
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public List<T> getLists() {
		return lists;
	}
	public void setLists(List<T> lists) {
		this.lists = lists;
	}

	@Override
	public String toString() {
		return "PageUtil{" +
				"pageindex=" + pageindex +
				", pagesize=" + pagesize +
				", counts=" + counts +
				", pagecount=" + pagecount +
				", lists=" + lists +
				'}';
	}
}
