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
@TableName("workcheck")
public class WorkcheckEntity implements Serializable {
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
	@ApiModelProperty(name = "weno",value = "")
	private String weno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "wtype",value = "")
	private String wtype;
	/**
	 * 
	 */
	@ApiModelProperty(name = "wrpamount",value = "")
	private String wrpamount;
	/**
	 * 
	 */
	@ApiModelProperty(name = "wcharge",value = "")
	private String wcharge;
	/**
	 * 
	 */
	@ApiModelProperty(name = "wtime",value = "")
	private Date wtime;

}
