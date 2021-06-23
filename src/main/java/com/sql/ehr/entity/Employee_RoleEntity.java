package com.sql.ehr.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
@TableName("employee_role")
public class Employee_RoleEntity {
    private static final long serialVersionUID = 1L;
    @TableId
    @ApiModelProperty(name = "eno",value = "")
    private String eno;
    @TableId
    @ApiModelProperty(name = "roleid",value = "")
    private String roleid;
}
