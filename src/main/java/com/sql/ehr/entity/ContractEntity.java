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
@TableName("contract")
public class ContractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "cno",value = "")
	private String cno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "ceno",value = "")
	private String ceno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "cbeigntime",value = "")
	private Date cbeigntime;
	/**
	 * 
	 */
	@ApiModelProperty(name = "cendtime",value = "")
	private Date cendtime;
	/**
	 * 
	 */
	@ApiModelProperty(name = "cpno",value = "")
	private String cpno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "ccontent",value = "")
	private String ccontent;
	/**
	 * 
	 */
	@ApiModelProperty(name = "cremarks",value = "")
	private String cremarks;

}
