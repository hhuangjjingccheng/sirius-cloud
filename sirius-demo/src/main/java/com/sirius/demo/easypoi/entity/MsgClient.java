package com.sirius.demo.easypoi.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName MsgClient.java
 * @Description TODO
 * @createTime 2022年08月05日 09:50:00
 */
@Data
public class MsgClient {

    private Date birthday;
    private String clientName;
    private String clientPhone;
    private String createBy;
    private String id;
    private String remark;
    private MsgClientGroup group;

}
