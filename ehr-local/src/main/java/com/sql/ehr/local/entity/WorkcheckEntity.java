package com.sql.ehr.local.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 考勤记录表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@ApiModel
@Data
@TableName("workcheck")
public class WorkcheckEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   考勤编号（主键）  
	 */
	@TableId
	@ApiModelProperty(name = "wno",value = "  考勤编号（主键）  ")
	private Integer wno;
	/**
	 *   员工编号（employee主键eno）  
	 */
	@ApiModelProperty(name = "employeeEno",value = "  员工编号（employee主键eno）  ")
	private Integer employeeEno;
	/**
	 *   类型（正常上班0、迟到1、旷工2、请假3、加班4、出差5、调班6、停工7）  
	 */
	@ApiModelProperty(name = "wtype",value = "  类型（正常上班0、迟到1、旷工2、请假3、加班4、出差5、调班6、停工7）  ")
	private String wtype;
	/**
	 *   奖惩金额  
	 */
	@ApiModelProperty(name = "wrpamount",value = "  奖惩金额  ")
	private String wrpamount;
	/**
	 *   考勤负责人  
	 */
	@ApiModelProperty(name = "wcharge",value = "  考勤负责人  ")
	private String wcharge;
	/**
	 *   上班时间  
	 */
	@ApiModelProperty(name = "wstarttime",value = "  上班时间  ")
	private Date wstarttime;
	/**
	 *   下班时间  
	 */
	@ApiModelProperty(name = "wendtime",value = "  下班时间  ")
	private Date wendtime;
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
