package com.sql.ehr.local.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 培训项目表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
@ApiModel
@Data
@TableName("trainproject")
public class TrainprojectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   项目编号  
	 */
	@TableId
	@ApiModelProperty(name = "tno",value = "  项目编号  ")
	private Integer tno;
	/**
	 *   培训内容  
	 */
	@ApiModelProperty(name = "tcontent",value = "  培训内容  ")
	private String tcontent;
	/**
	 *   培训人  
	 */
	@ApiModelProperty(name = "ttrainer",value = "  培训人  ")
	private String ttrainer;
	/**
	 *   培训类别（岗前培训0/在职培训1）  
	 */
	@ApiModelProperty(name = "ttype",value = "  培训类别（岗前培训0/在职培训1）  ")
	private String ttype;
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
