package com.sql.ehr.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;
@Data
@ApiModel
@TableName("application")
public class GeneralEmployee implements Serializable {
    private String eno;
    private String ename;
    private String egender;
    private Date ebirthday;
    private String ephone;
    private String eemail;
    private String eeducation;
    private String edno;
    private String epno;
    private Date eentytime;
    private String estatus;
    private String erole;
    private String eremarks;
    private String eaccount;
    private String epassword;
    private String dname;
    private String pname;
    private String ano;
    private String aname;
    private String acontent;
    private String aremarks;

}
