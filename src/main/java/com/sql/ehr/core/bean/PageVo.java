/**
 * Copyright (c) 2016-2019 谷粒开源 All rights reserved.
 *
 * https://www.guli.cloud
 *
 * 版权所有，侵权必究！
 */

package com.sql.ehr.core.bean;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页器
 *
 * @author Mark sunlightcs@gmail.com
 */
@ApiModel
@Data
public class PageVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 总记录数
	 */
	private int totalCount;
	/**
	 * 每页记录数
	 */
	private int pageSize;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 当前页数
	 */
	private int currPage;
	/**
	 * 列表数据
	 */
	private List<?> list;
	
	/**
	 * 分页（查询一页数据时的构造函数）
	 * @param list        列表数据
	 * @param totalCount  总记录数
	 * @param pageSize    每页记录数
	 * @param currPage    当前页数
	 */
	public PageVo(List<?> list, int totalCount,int currPage,int pageSize) {
		this.list = list;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currPage = currPage;
		int tmp=totalCount%pageSize;
		if(tmp==0){
			this.totalPage = totalCount/pageSize;
		}else{
			this.totalPage = (totalCount/pageSize)+1;
		}
	}

	/**
	 * 分页（查询所有数据时的构造函数）,map里传入分页参数limit,page
	 * @param list
	 * @param map
	 */
	public PageVo(List<?> list, HashMap<String,Object>map) {
		if(list.size()!=0) {
			this.totalCount = list.size();
			this.pageSize =Integer.parseInt(map.get("limit").toString());
			this.currPage =Integer.parseInt(map.get("page").toString());
			int tmp = totalCount % pageSize;
			if (tmp == 0) {
				this.totalPage = totalCount / pageSize;
			} else {
				this.totalPage = (totalCount / pageSize) + 1;
			}
			//currPage==totalPage的情况只会是到了最后一页
			int remain = (currPage == totalPage) ? (totalCount % pageSize) : pageSize;
			if(currPage == totalPage && (totalCount % pageSize)==0){
				//此情况为到了最后一页，刚好最后一页数据是填满的情况(如总页数10的第一页十条，总页数20的第二页后十条等)，
				// remain此时为0，需要重置为pageSize的值
				remain=pageSize;
			}
			this.list = list.subList((currPage - 1) * pageSize, (currPage - 1) * pageSize + remain);
		}else {	//查不到list数据的分页
			this.totalCount=0;
			this.totalPage=0;
			this.pageSize =Integer.parseInt(map.get("limit").toString());
			this.currPage =Integer.parseInt(map.get("page").toString());
		}
	}

	/**
	 * 分页（查询所有数据时的构造函数）,传入分页参数QueryCondition
	 * @param list
	 * @param queryCondition
	 */
	public PageVo(List<?> list,  QueryCondition queryCondition) {
		if(list.size()!=0) {
			this.totalCount = list.size();
			this.pageSize = queryCondition.getLimit().intValue();
			this.currPage = queryCondition.getPage().intValue();
			int tmp = totalCount % pageSize;
			if (tmp == 0) {
				this.totalPage = totalCount / pageSize;
			} else {
				this.totalPage = (totalCount / pageSize) + 1;
			}
			int remain = (currPage == totalPage) ? (totalCount % pageSize) : pageSize;
			if(currPage == totalPage && (totalCount % pageSize)==0){
				//此情况为到了最后一页，刚好最后一页数据是填满的情况(如总页数10的第一页十条，总页数20的第二页后十条等)，
				// remain此时为0，需要重置为pageSize的值
				remain=pageSize;
			}
			this.list = list.subList((currPage - 1) * pageSize, (currPage - 1) * pageSize + remain);
		}else {	//查不到list数据的分页
			this.totalCount=0;
			this.totalPage=0;
			this.pageSize = queryCondition.getLimit().intValue();
			this.currPage = queryCondition.getPage().intValue();
		}
	}

	/**
	 * 分页（查询所有数据时的构造函数）,传入自定义分页参数
	 * @param list
	 * @param pageSize  页面记录数
	 * @param currPage  当前在第几页
	 */
	public PageVo(List<?> list, int currPage,  int pageSize) {
		this.totalCount = list.size();
		this.pageSize = pageSize;
		this.currPage = currPage;
		int tmp=totalCount%pageSize;
		if(tmp==0){
			this.totalPage = totalCount/pageSize;
		}else{
			this.totalPage = (totalCount/pageSize)+1;
		}
		int remain=(currPage==totalPage)?(totalCount%pageSize):pageSize;
		if(currPage == totalPage && (totalCount % pageSize)==0){
			//此情况为到了最后一页，刚好最后一页数据是填满的情况(如总页数10的第一页十条，总页数20的第二页后十条等)，
			// remain此时为0，需要重置为pageSize的值
			remain=pageSize;
		}
		this.list = list.subList((currPage - 1) * pageSize, (currPage - 1) * pageSize + remain);
	}
	/**
	 * 分页
	 */
	public PageVo(IPage<?> page) {
		this.list = page.getRecords();
		this.totalCount = (int)page.getTotal();
		this.pageSize = (int)page.getSize();
		this.currPage = (int)page.getCurrent();
		this.totalPage = (int)page.getPages();
	}


	
}
