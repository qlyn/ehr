package com.sql.ehr.local.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工基本信息表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@ApiModel
@Data
@TableName("employee")
public class EmployeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   员工编号（主键）
	 */
	@TableId
	@ApiModelProperty(name = "no",value = "  员工编号（主键）")
	private Integer no;
	/**
	 *   姓名  
	 */
	@ApiModelProperty(name = "name",value = "  姓名  ")
	private String name;
	/**
	 *   性别  
	 */
	@ApiModelProperty(name = "gender",value = "  性别  ")
	private String gender;
	/**
	 *   出生日期  
	 */
	@ApiModelProperty(name = "birthday",value = "  出生日期  ")
	private Date birthday;
	/**
	 *   联系电话  
	 */
	@ApiModelProperty(name = "phone",value = "  联系电话  ")
	private String phone;
	/**
	 *   邮箱地址  
	 */
	@ApiModelProperty(name = "email",value = "  邮箱地址  ")
	private String email;
	/**
	 *   学历  
	 */
	@ApiModelProperty(name = "education",value = "  学历  ")
	private String education;
	/**
	 *   部门号（department主键dno）  
	 */
	@ApiModelProperty(name = "departmentNo",value = "  部门号（department主键dno）  ")
	private Integer departmentNo;
	/**
	 *   职务（post主键pno）  
	 */
	@ApiModelProperty(name = "postNo",value = "  职务（post主键pno）  ")
	private Integer postNo;
	/**
	 *   入职时间  
	 */
	@ApiModelProperty(name = "entryTime",value = "  入职时间  ")
	private Date entryTime;
	/**
	 *   人员状态（在职/兼职/离职/退休）  
	 */
	@ApiModelProperty(name = "status",value = "  人员状态（在职/兼职/离职/退休）  ")
	private String status;
	/**
	 *   备注  
	 */
	@ApiModelProperty(name = "remarks",value = "  备注  ")
	private String remarks;
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
