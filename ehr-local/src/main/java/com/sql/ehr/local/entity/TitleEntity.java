package com.sql.ehr.local.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 职称基本信息表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
@ApiModel
@Data
@TableName("title")
public class TitleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   职称号（主键）  
	 */
	@TableId
	@ApiModelProperty(name = "tno",value = "  职称号（主键）  ")
	private Integer tno;
	/**
	 *   职称名  
	 */
	@ApiModelProperty(name = "tname",value = "  职称名  ")
	private String tname;
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
