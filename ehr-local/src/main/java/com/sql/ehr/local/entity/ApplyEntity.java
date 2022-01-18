package com.sql.ehr.local.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工申请职称信息表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
@ApiModel
@Data
@TableName("apply")
public class ApplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   申请号  
	 */
	@TableId
	@ApiModelProperty(name = "ano",value = "  申请号  ")
	private Integer ano;
	/**
	 *   申请职称  
	 */
	@ApiModelProperty(name = "atitilename",value = "  申请职称  ")
	private String atitilename;
	/**
	 *   申请日期  
	 */
	@ApiModelProperty(name = "aobtaintime",value = "  申请日期  ")
	private Date aobtaintime;
	/**
	 *   年度职称评定信息  
	 */
	@ApiModelProperty(name = "aevaluateinf",value = "  年度职称评定信息  ")
	private String aevaluateinf;
	/**
	 *   年度考核结果  
	 */
	@ApiModelProperty(name = "aresult",value = "  年度考核结果  ")
	private String aresult;
	/**
	 *   资格年份  
	 */
	@ApiModelProperty(name = "ayear",value = "  资格年份  ")
	private Date ayear;
	/**
	 *   员工编号（employee主键eno）  
	 */
	@ApiModelProperty(name = "employeeEno",value = "  员工编号（employee主键eno）  ")
	private Integer employeeEno;
	/**
	 *   职称号（title主键tno）  
	 */
	@ApiModelProperty(name = "titleTno",value = "  职称号（title主键tno）  ")
	private Integer titleTno;
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
