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
@TableName("post")
public class PostEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "pno",value = "")
	private String pno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "pname",value = "")
	private String pname;
	/**
	 * 
	 */
	@ApiModelProperty(name = "pfixpost",value = "")
	private String pfixpost;
	/**
	 * 
	 */
	@ApiModelProperty(name = "plackpost",value = "")
	private String plackpost;
	/**
	 * 
	 */
	@ApiModelProperty(name = "pdno",value = "")
	private String pdno;

}
