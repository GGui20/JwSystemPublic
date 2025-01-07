package com.zxw.common.pojo;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuNode {
    private Long id;
    private String name;
    private String component;
    private Boolean hidden;
    private String path;
    private Boolean alwaysShow;
    private Long pid;
    private MenuMeta meta;
    private String redirect;
    private List<MenuNode> children;

    // 默认无参构造方法
    public MenuNode() {
        this.children = new ArrayList<>();
    }
}
