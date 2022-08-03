package com.sirius.demo.thread.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName ParameterEntity.java
 * @Description TODO
 * @createTime 2022年08月03日 15:46:00
 */
@TableName("Parameter")
@Data
public class ParameterEntity implements Serializable {
    private String stasType,stasMark,stasName,stasVal1,	stasVal2,stasVal3,stasNote;
}
