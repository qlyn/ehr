package com.sql.ehr.local.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 薪酬记录表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@ApiModel
@Data
@TableName("pay")
public class PayEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   薪酬编号（主键）  
	 */
	@TableId
	@ApiModelProperty(name = "wno",value = "  薪酬编号（主键）  ")
	private Integer wno;
	/**
	 *   员工编号（employee主键eno）  
	 */
	@ApiModelProperty(name = "employeeEno",value = "  员工编号（employee主键eno）  ")
	private Integer employeeEno;
	/**
	 *   基本工资  
	 */
	@ApiModelProperty(name = "wbase",value = "  基本工资  ")
	private String wbase;
	/**
	 *   绩效工资  
	 */
	@ApiModelProperty(name = "wachievement",value = "  绩效工资  ")
	private String wachievement;
	/**
	 *   奖金  
	 */
	@ApiModelProperty(name = "wbonus",value = "  奖金  ")
	private String wbonus;
	/**
	 *   罚款  
	 */
	@ApiModelProperty(name = "wfine",value = "  罚款  ")
	private String wfine;
	/**
	 *   薪酬数目  
	 */
	@ApiModelProperty(name = "wsalary",value = "  薪酬数目  ")
	private String wsalary;
	/**
	 *   获薪时间  
	 */
	@ApiModelProperty(name = "wtime",value = "  获薪时间  ")
	private Date wtime;
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
