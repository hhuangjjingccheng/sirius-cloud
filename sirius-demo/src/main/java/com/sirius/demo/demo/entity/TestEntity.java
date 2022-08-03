package com.sirius.demo.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName TestEntity.java
 * @Description TODO
 * @createTime 2022年08月03日 15:32:00
 */
@TableName("test")
public class TestEntity {
    private String id;
    private String xm;
    private String xb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }
}
