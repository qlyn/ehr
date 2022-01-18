package com.sql.ehr.local.core.query;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * XXXXXX
 *
 * @author 沈钦林
 * @date 2021/12/7 14:40
 */
@ApiModel("入职参数")
@Data
public class InductionQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *   招聘编号
     */
    @TableId
    @ApiModelProperty(name = "rno",value = "  招聘编号  ")
    private Integer rno;
    /**
     *   招聘状态（0未处理、1笔试过、2面试过、3签约完成）
     */
    @ApiModelProperty(name = "status",value = "  招聘状态（0未处理、1笔试过、2面试过、3签约完成）  ")
    private String status;
    /**
     *   要求学历
     */
    @ApiModelProperty(name = "education",value = "  要求学历  ")
    private String education;
    /**
     *   部门号（department主键dno）
     */
    @ApiModelProperty(name = "departmentNo",value = "  部门号（department主键dno）  ")
    private Integer departmentNo;
    /**
     *   岗位编号（post主键pno）
     */
    @ApiModelProperty(name = "postNo",value = "  岗位编号（post主键pno）  ")
    private Integer postNo;
    /**
     *   发布时间
     */
    @ApiModelProperty(name = "releaseTime",value = "  发布时间  ")
    private Date releaseTime;



    /**
     *   应聘编号（主键）
     */
    @TableId
    @ApiModelProperty(name = "ano",value = "  应聘编号（主键）  ")
    private Integer ano;

    /**
     *   姓名
     */
    @ApiModelProperty(name = "name",value = "  姓名  ")
    private String name;
    /**
     *   性别
     */
    @ApiModelProperty(name = "gender",value = "  性别  ")
    private String gender;
    /**
     *   出生日期
     */
    @ApiModelProperty(name = "birthday",value = "  出生日期  ")
    private Date birthday;
    /**
     *   联系电话
     */
    @ApiModelProperty(name = "phone",value = "  联系电话  ")
    private String phone;
    /**
     *   邮箱地址
     */
    @ApiModelProperty(name = "email",value = "  邮箱地址  ")
    private String email;






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
