package com.sql.ehr.local.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

/**
 * 部门基本信息表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
@ApiModel
@Data
@TableName("department")
@Repository
public class DepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   部门号  
	 */
	@TableId
	@ApiModelProperty(name = "no",value = "  部门号  ")
	private Integer no;
	/**
	 *   部门名称  
	 */
	@ApiModelProperty(name = "name",value = "  部门名称  ")
	private String name;
	/**
	 *   成立时间  
	 */
	@ApiModelProperty(name = "establishTime",value = "  成立时间  ")
	private Date establishTime;
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
