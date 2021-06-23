package com.sql.ehr.bean;

import com.sql.ehr.entity.PermissionEntity;
import lombok.Data;

import java.util.List;

/**
 * 菜单类
 */
@Data
public class Menu {
    @Data
    public static class HomeInfo{
        private String title;
        private String href;
    }
    @Data
    public static class LogoInfo{
        private String title;
        private String href;
        private String image;
    }
}
