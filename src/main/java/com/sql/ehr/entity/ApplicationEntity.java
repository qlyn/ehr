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
@TableName("application")
public class ApplicationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "ano",value = "")
	private String ano;
	/**
	 * 
	 */
	@ApiModelProperty(name = "aname",value = "")
	private String aname;
	/**
	 * 
	 */
	@ApiModelProperty(name = "agender",value = "")
	private String agender;
	/**
	 * 
	 */
	@ApiModelProperty(name = "abirthday",value = "")
	private Date abirthday;
	/**
	 * 
	 */
	@ApiModelProperty(name = "aphone",value = "")
	private String aphone;
	/**
	 * 
	 */
	@ApiModelProperty(name = "aemail",value = "")
	private String aemail;
	/**
	 * 
	 */
	@ApiModelProperty(name = "apno",value = "")
	private String apno;

}
