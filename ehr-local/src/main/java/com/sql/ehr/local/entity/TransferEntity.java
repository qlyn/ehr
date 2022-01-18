package com.sql.ehr.local.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 人事调动信息表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@ApiModel
@Data
@TableName("transfer")
public class TransferEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   调动编号  
	 */
	@TableId
	@ApiModelProperty(name = "tno",value = "  调动编号  ")
	private Integer tno;
	/**
	 *   员工编号（employee主键eno）  
	 */
	@ApiModelProperty(name = "employeeEno",value = "  员工编号（employee主键eno）  ")
	private Integer employeeEno;
	/**
	 *   原职务（post主键pno）  
	 */
	@ApiModelProperty(name = "oldPostPno",value = "  原职务（post主键pno）  ")
	private Integer oldPostPno;
	/**
	 *   新职务（post主键pno）  
	 */
	@ApiModelProperty(name = "newPostPno",value = "  新职务（post主键pno）  ")
	private Integer newPostPno;
	/**
	 *   调动时间  
	 */
	@ApiModelProperty(name = "ttime",value = "  调动时间  ")
	private Date ttime;
	/**
	 *   调动原因  
	 */
	@ApiModelProperty(name = "treason",value = "  调动原因  ")
	private String treason;
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
