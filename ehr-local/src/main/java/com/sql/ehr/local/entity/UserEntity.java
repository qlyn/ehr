package com.sql.ehr.local.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
@ApiModel
@Data
@Repository
@TableName("user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   用户编号（主键）
	 */
	@TableId
	@ApiModelProperty(name = "uno",value = "  用户编号（主键）")
	private Integer uno;
	/**
	 *   姓名  
	 */
	@ApiModelProperty(name = "uname",value = "  姓名  ")
	private String uname;
	/**
	 *   角色（管理员/普通用户/员工信息管理/人事调配管理/教育培训管理/考勤管理/招聘管理）  
	 */
	@ApiModelProperty(name = "urole",value = "  角色（管理员/普通用户/员工信息管理/人事调配管理/教育培训管理/考勤管理/招聘管理）  ")
	private String urole;
	/**
	 *   注册邮箱
	 */
	@ApiModelProperty(name = "uemail",value = "  注册邮箱  ")
	private String uemail;
	/**
	 *   账户  
	 */
	@ApiModelProperty(name = "uaccount",value = "  账户  ")
	private String uaccount;
	/**
	 *   密码  
	 */
	@ApiModelProperty(name = "upassword",value = "  密码  ")
	private String upassword;
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
