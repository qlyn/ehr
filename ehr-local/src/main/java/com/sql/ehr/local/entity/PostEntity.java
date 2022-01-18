package com.sql.ehr.local.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 岗位基本信息表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@ApiModel
@Data
@TableName("post")
public class PostEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   岗位号  
	 */
	@TableId
	@ApiModelProperty(name = "no",value = "  岗位号  ")
	private Integer no;
	/**
	 *   岗位名称  
	 */
	@ApiModelProperty(name = "name",value = "  岗位名称  ")
	private String name;
	/**
	 *   定员数量（定了几个岗）  
	 */
	@ApiModelProperty(name = "fixpost",value = "  定员数量（定了几个岗）  ")
	private String fixpost;
	/**
	 *   缺员数量（实际招聘后缺了几个岗）  
	 */
	@ApiModelProperty(name = "lackpost",value = "  缺员数量（实际招聘后缺了几个岗）  ")
	private String lackpost;
	/**
	 *   所属部门（department主键dno）  
	 */
	@ApiModelProperty(name = "departmentNo",value = "  所属部门（department主键dno）  ")
	private Integer departmentNo;
	/**
	 *   创建时间  
	 */
	@ApiModelProperty(name = "createTime",value = "  创建时间  ")
	private Date createTime;
	/**
	 *   创建人  
	 */
	@ApiModelProperty(name = "createUser",value = "  创建人  ")
	private String createUser;
	/**
	 *   更新时间  
	 */
	@ApiModelProperty(name = "updateTime",value = "  更新时间  ")
	private Date updateTime;
	/**
	 *   更新人  
	 */
	@ApiModelProperty(name = "updateUser",value = "  更新人  ")
	private String updateUser;

}
