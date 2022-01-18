package com.sql.ehr.local.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 合同基本信息表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@ApiModel
@Data
@TableName("contract")
public class ContractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   合同编号  
	 */
	@TableId
	@ApiModelProperty(name = "cno",value = "  合同编号  ")
	private Integer cno;
	/**
	 *   员工编号（employee主键eno）  
	 */
	@ApiModelProperty(name = "employeeEno",value = "  员工编号（employee主键eno）  ")
	private Integer employeeEno;
	/**
	 *   合同的开始日期  
	 */
	@ApiModelProperty(name = "cbeigntime",value = "  合同的开始日期  ")
	private Date cbeigntime;
	/**
	 *   合同的结束日期  
	 */
	@ApiModelProperty(name = "cendtime",value = "  合同的结束日期  ")
	private Date cendtime;
	/**
	 *   职务（post主键pno）  
	 */
	@ApiModelProperty(name = "postPno",value = "  职务（post主键pno）  ")
	private Integer postPno;
	/**
	 *   合同内容  
	 */
	@ApiModelProperty(name = "ccontent",value = "  合同内容  ")
	private String ccontent;
	/**
	 *   备注  
	 */
	@ApiModelProperty(name = "cremarks",value = "  备注  ")
	private String cremarks;
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
