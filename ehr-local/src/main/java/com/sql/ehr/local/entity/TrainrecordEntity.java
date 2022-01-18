package com.sql.ehr.local.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 培训记录表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@ApiModel
@Data
@TableName("trainrecord")
public class TrainrecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   项目编号 
	 */
	@TableId
	@ApiModelProperty(name = "tno",value = "  项目编号 ")
	private Integer tno;
	/**
	 *   培训结果
	 */
	@ApiModelProperty(name = "tresult",value = "  培训结果")
	private String tresult;
	/**
	 *   评定结果（是0/否1）
	 */
	@ApiModelProperty(name = "tevaluate",value = "  评定结果（是0/否1）")
	private String tevaluate;
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
