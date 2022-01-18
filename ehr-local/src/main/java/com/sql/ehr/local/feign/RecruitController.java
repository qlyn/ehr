package com.sql.ehr.local.feign;

import com.sql.ehr.external.dto.RecruitEntity;
import com.sql.ehr.local.core.bean.Resp;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * XXXXXX
 *
 * @author 沈钦林
 * @date 2021/12/18 14:45
 */
@FeignClient(value = "ehr-external")
@RequestMapping("ehr/recruit")
public interface RecruitController {
    @ApiOperation("修改")
    @PostMapping("/update")
    public Resp<Object> update(@RequestBody RecruitEntity recruit);
}
