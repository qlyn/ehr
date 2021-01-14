package com.sql.ehr.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 */
@ApiModel
@Data
@TableName("pay")
public class PayEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "wno",value = "")
	private String wno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "peno",value = "")
	private String peno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "wbase",value = "")
	private String wbase;
	/**
	 * 
	 */
	@ApiModelProperty(name = "wachievement",value = "")
	private String wachievement;
	/**
	 * 
	 */
	@ApiModelProperty(name = "wbonus",value = "")
	private String wbonus;
	/**
	 * 
	 */
	@ApiModelProperty(name = "wfine",value = "")
	private String wfine;
	/**
	 * 
	 */
	@ApiModelProperty(name = "wsalary",value = "")
	private String wsalary;
	/**
	 * 
	 */
	@ApiModelProperty(name = "wtime",value = "")
	private Date wtime;

}
