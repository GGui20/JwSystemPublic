package com.zxw.common.pojo;

import lombok.Data;

@Data
public class MenuMeta {
    private String title; // 通常菜单项的名称被称为标题
    private String icon;

    // 默认无参构造方法
    public MenuMeta() {
    }

    public MenuMeta(String title, String icon) {
        this.title = title;
        this.icon = icon;
    }
}
