package com.sql.ehr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.Query;
import com.sql.ehr.core.bean.QueryCondition;
import com.sql.ehr.dao.EmployeeDao;
import com.sql.ehr.dao.PostDao;
import com.sql.ehr.entity.EmployeeEntity;
import com.sql.ehr.entity.PostEntity;
import com.sql.ehr.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("postService")
public class PostServiceImpl extends ServiceImpl<PostDao, PostEntity> implements PostService {

}