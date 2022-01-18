package com.sql.ehr.local.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 档案基本信息表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
@ApiModel
@Data
@TableName("archives")
public class ArchivesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   档案编号  
	 */
	@TableId
	@ApiModelProperty(name = "ano",value = "  档案编号  ")
	private Integer ano;
	/**
	 *   员工编号（employee主键eno）  
	 */
	@ApiModelProperty(name = "employeeEno",value = "  员工编号（employee主键eno）  ")
	private Integer employeeEno;
	/**
	 *   档案名称  
	 */
	@ApiModelProperty(name = "aname",value = "  档案名称  ")
	private String aname;
	/**
	 *   内容摘要  
	 */
	@ApiModelProperty(name = "acontent",value = "  内容摘要  ")
	private String acontent;
	/**
	 *   备注  
	 */
	@ApiModelProperty(name = "aremarks",value = "  备注  ")
	private String aremarks;
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
