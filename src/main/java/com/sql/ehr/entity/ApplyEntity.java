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
@TableName("apply")
public class ApplyEntity implements Serializable {
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
	@ApiModelProperty(name = "atitilename",value = "")
	private String atitilename;
	/**
	 * 
	 */
	@ApiModelProperty(name = "aobtaintime",value = "")
	private Date aobtaintime;
	/**
	 * 
	 */
	@ApiModelProperty(name = "aevaluateinf",value = "")
	private String aevaluateinf;
	/**
	 * 
	 */
	@ApiModelProperty(name = "aresult",value = "")
	private String aresult;
	/**
	 * 
	 */
	@ApiModelProperty(name = "ayear",value = "")
	private Date ayear;
	/**
	 * 
	 */
	@ApiModelProperty(name = "aeno",value = "")
	private String aeno;
	/**
	 * 
	 */
	@ApiModelProperty(name = "atno",value = "")
	private String atno;

}
