package com.sql.ehr.external.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 招聘信息表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-08 23:57:13
 */
@ApiModel
@Data
@TableName("recruit")
public class RecruitEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   招聘编号  
	 */
	@TableId
	@ApiModelProperty(name = "no",value = "  招聘编号  ")
	private Integer no;
	/**
	 *   招聘状态（0未处理、1笔试过、2面试过、3签约完成）  
	 */
	@ApiModelProperty(name = "status",value = "  招聘状态（0未处理、1笔试过、2面试过、3签约完成）  ")
	private String status;
	/**
	 *   要求学历  
	 */
	@ApiModelProperty(name = "education",value = "  要求学历  ")
	private String education;
	/**
	 *   部门号（department主键dno）  
	 */
	@ApiModelProperty(name = "departmentNo",value = "  部门号（department主键dno）  ")
	private Integer departmentNo;
	/**
	 *   岗位编号（post主键pno）  
	 */
	@ApiModelProperty(name = "postNo",value = "  岗位编号（post主键pno）  ")
	private Integer postNo;
	/**
	 *   发布时间  
	 */
	@ApiModelProperty(name = "releaseTime",value = "  发布时间  ")
	private Date releaseTime;
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
