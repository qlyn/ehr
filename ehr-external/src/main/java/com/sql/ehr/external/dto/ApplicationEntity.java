package com.sql.ehr.external.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

/**
 * 应聘信息表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-08 23:57:13
 */
@ApiModel
@Data
@TableName("application")
@Repository
public class ApplicationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   应聘编号（主键）  
	 */
	@TableId
	@ApiModelProperty(name = "no",value = "  应聘编号（主键）  ")
	private Integer no;

	/**
	 *  招聘编号 （recruit主键rno ）
	 */
	@ApiModelProperty(name = "recruitNo",value = "  招聘编号 （recruit主键rno ）  ")
	private Integer recruitNo;
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
	 *   岗位编号（post主键pno ） 
	 */
	@ApiModelProperty(name = "postNo",value = "  岗位编号（post主键pno ） ")
	private Integer postNo;
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
