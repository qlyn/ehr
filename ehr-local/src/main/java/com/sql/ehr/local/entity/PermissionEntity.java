package com.sql.ehr.local.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 权限表（菜单表）
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@ApiModel
@Data
@TableName("permission")
public class PermissionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 角色编号（主键） 
	 */
	@TableId
	@ApiModelProperty(name = "pno",value = "角色编号（主键） ")
	private Integer pno;
	/**
	 * 父菜单编号  
	 */
	@ApiModelProperty(name = "parentno",value = "父菜单编号  ")
	private Integer parentno;
	/**
	 * 菜单名（layui前端要求）  
	 */
	@ApiModelProperty(name = "title",value = "菜单名（layui前端要求）  ")
	private String title;
	/**
	 * 菜单链接（layui前端要求），父菜单为空，只有最后叶子菜单需要指定跳转链接)  
	 */
	@ApiModelProperty(name = "href",value = "菜单链接（layui前端要求），父菜单为空，只有最后叶子菜单需要指定跳转链接)  ")
	private String href;
	/**
	 * 菜单图标（layui前端要求）  
	 */
	@ApiModelProperty(name = "icon",value = "菜单图标（layui前端要求）  ")
	private String icon;
	/**
	 * 自定义（layui前端要求），所有菜单默认都为_self，不可为空  
	 */
	@ApiModelProperty(name = "target",value = "自定义（layui前端要求），所有菜单默认都为_self，不可为空  ")
	private String target;
	/**
	 * 子菜单（layui前端要求），有子菜单时有值  
	 */
	@ApiModelProperty(name = "child",value = "子菜单节点列表（layui前端要求），数据库表结果没有，有子菜单时有值  ")
	private List<PermissionEntity> child;
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
