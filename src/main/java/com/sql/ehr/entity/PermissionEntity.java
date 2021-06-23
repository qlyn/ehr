package com.sql.ehr.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@ApiModel
@Data
@TableName("permission")
public class PermissionEntity {
    private static final long serialVersionUID = 1L;
    @TableId
    @ApiModelProperty(name = "perssionid",value = "")
    private String perssionid;
    @TableId
    @ApiModelProperty(name = "parentId",value = "")
    private String parentId;
    @TableId
    @ApiModelProperty(name = "title",value = "")
    private String title;
    @TableId
    @ApiModelProperty(name = "href",value = "")
    private String href;
    @TableId
    @ApiModelProperty(name = "icon",value = "")
    private String icon;
    @TableId
    @ApiModelProperty(name = "target",value = "")
    private String target;

    @TableId
    @ApiModelProperty(name = "target",value = "")
    private List<PermissionEntity> child;
}
