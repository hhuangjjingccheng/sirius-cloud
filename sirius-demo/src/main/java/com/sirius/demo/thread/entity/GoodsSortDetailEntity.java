package com.sirius.demo.thread.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName GoodsSortDetailEntity.java
 * @Description TODO
 * @createTime 2022年08月03日 15:53:00
 */
@Data
@TableName("goods_sort_detail")
public class GoodsSortDetailEntity implements Serializable {

    private String id;

    /**
     * 商品编码
     */
    private String goodsCode;
    /**
     * 分类名称
     */
    private String stalZd;

    private String ieType;


}
