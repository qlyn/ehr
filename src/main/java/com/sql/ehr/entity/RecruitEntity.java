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
@TableName("recruit")
public class RecruitEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "rno",value = "")
	private String rno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "rano",value = "")
	private String rano;
	/**
	 * 
	 */
	@ApiModelProperty(name = "rstatus",value = "")
	private String rstatus;
	/**
	 * 
	 */
	@ApiModelProperty(name = "reducation",value = "")
	private String reducation;
	/**
	 * 
	 */
	@ApiModelProperty(name = "rdno",value = "")
	private String rdno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "pno",value = "")
	private String pno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "relaeasetime",value = "")
	private Date relaeasetime;

}
