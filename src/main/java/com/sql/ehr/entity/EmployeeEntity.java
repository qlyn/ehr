package com.sql.ehr.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 * @TableName：指定数据表表名，当类名与表名不一致时使用
 */
@ApiModel
@Data
@TableName("employee")
public class EmployeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "eno",value = "")
	private String eno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "ename",value = "")
	private String ename;
	/**
	 * 
	 */
	@ApiModelProperty(name = "egender",value = "")
	private String egender;
	/**
	 * 
	 */
	@ApiModelProperty(name = "ebirthday",value = "")
	private Date ebirthday;
	/**
	 * 
	 */
	@ApiModelProperty(name = "ephone",value = "")
	private String ephone;
	/**
	 * 
	 */
	@ApiModelProperty(name = "eemail",value = "")
	private String eemail;
	/**
	 * 
	 */
	@ApiModelProperty(name = "eeducation",value = "")
	private String eeducation;
	/**
	 * 
	 */
	@ApiModelProperty(name = "edno",value = "")
	private String edno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "epno",value = "")
	private String epno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "eentytime",value = "")
	private Date eentytime;
	/**
	 * 
	 */
	@ApiModelProperty(name = "estatus",value = "")
	private String estatus;
	/**
	 * 
	 */
	@ApiModelProperty(name = "erole",value = "")
	private String erole;
	/**
	 * 
	 */
	@ApiModelProperty(name = "eremarks",value = "")
	private String eremarks;
	/**
	 * 
	 */
	@ApiModelProperty(name = "eaccount",value = "")
	private String eaccount;
	/**
	 * 
	 */
	@ApiModelProperty(name = "epassword",value = "")
	private String epassword;

}
