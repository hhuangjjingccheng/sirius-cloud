package com.sirius.demo.easypoi.entity;


import java.io.Serializable;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName MsgClientGroup.java
 * @Description TODO
 * @createTime 2022年08月05日 09:54:00
 */
public class MsgClientGroup implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6946265640897464878L;

    // 组名
    private String            groupName        = null;
    /**
     * 创建人
     */
    private String            createBy;

    public String getCreateBy() {
        return createBy;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}

