package com.yuntu.uitl;

import java.util.List;

//实现分页类
public class pageUtil<T> {
//	五个属性
	private int pageindex=1;//当前页（页码）
	private int pagesize=10;//页面大小
	private int counts=0;//记录总数
	private int pagecount=0;//总页数
	private List<T> lists;//保存当前页对象的集合
//	get，set
	/**
	 * @return the pageindex
	 */
	public int getPageindex() {
		return pageindex;
	}
	/**
	 * @param pageindex the pageindex to set
	 */
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	/**
	 * @return the pagesize
	 */
	public int getPagesize() {
		return pagesize;
	}
	/**
	 * @param pagesize the pagesize to set
	 */
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	/**
	 * @return the counts
	 */
	public int getCounts() {
		return counts;
	}
	/**
	 * @param counts the counts to set
	 */
	public void setCounts(int counts) {
		this.counts = counts;
//		在设置总记录数时，一并设置总页数
		if (counts>0) {
			if (counts%pagesize==0) {//判断是否能整除
				pagecount= counts/pagesize;
			}else {
				pagecount= counts/pagesize+1;
			}
		}
		
	}
	
	
	/**
	 * @return the pagecount
	 */
	public int getPagecount() {
		return pagecount;
	}
	/**
	 * @param pagecount the pagecount to set
	 */
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	/**
	 * @return the lists
	 */
	public List<T> getLists() {
		return lists;
	}
	/**
	 * @param lists the lists to set
	 */
	public void setLists(List<T> lists) {
		this.lists = lists;
	}
	
	                             
}
