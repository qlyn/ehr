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
@TableName("trainproject")
public class TrainprojectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "tpno",value = "")
	private String tpno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "tpcontent",value = "")
	private String tpcontent;
	/**
	 * 
	 */
	@ApiModelProperty(name = "tptrainer",value = "")
	private String tptrainer;
	/**
	 * 
	 */
	@ApiModelProperty(name = "tptype",value = "")
	private String tptype;

}
