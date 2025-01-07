package com.zxw.common.pojo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

public class TableResponse<T> {
    private long total; // 总记录数
    private int page;   // 当前页码
    private int size;   // 每页条目数量
    private List<T> data; // 数据列表

    // 默认无参构造方法
    public TableResponse() {}

    // 带参数的构造方法
    public TableResponse(long total, int page, int size, List<T> data) {
        this.total = total;
        this.page = page;
        this.size = size;
        this.data = data;
    }

    // 静态工厂方法，用于从分页结果创建 TableResponse 实例
    public static <T> TableResponse<T> of(IPage<T> pageResult) {
        return new TableResponse<>(
                pageResult.getTotal(), // 确保 getTotal() 返回 long 类型
                (int) pageResult.getCurrent(), // 如果 getCurrent() 返回 long 或其他类型，请确保转换为 int
                (int) pageResult.getSize(), // 如果 getSize() 返回 long 或其他类型，请确保转换为 int
                pageResult.getRecords()
        );
    }

    // Getters and Setters (省略，但你应当实现这些方法)

    // Getter for total
    public long getTotal() {
        return total;
    }

    // Setter for total
    public void setTotal(long total) {
        this.total = total;
    }

    // Getter for page
    public int getPage() {
        return page;
    }

    // Setter for page
    public void setPage(int page) {
        this.page = page;
    }

    // Getter for size
    public int getSize() {
        return size;
    }

    // Setter for size
    public void setSize(int size) {
        this.size = size;
    }

    // Getter for data
    public List<T> getData() {
        return data;
    }

    // Setter for data
    public void setData(List<T> data) {
        this.data = data;
    }
}