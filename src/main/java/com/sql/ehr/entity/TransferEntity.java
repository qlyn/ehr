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
@TableName("transfer")
public class TransferEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "tno",value = "")
	private String tno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "teno",value = "")
	private String teno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "tprepost",value = "")
	private String tprepost;
	/**
	 * 
	 */
	@ApiModelProperty(name = "tcurpost",value = "")
	private String tcurpost;
	/**
	 * 
	 */
	@ApiModelProperty(name = "ttime",value = "")
	private Date ttime;
	/**
	 * 
	 */
	@ApiModelProperty(name = "treason",value = "")
	private String treason;

}
