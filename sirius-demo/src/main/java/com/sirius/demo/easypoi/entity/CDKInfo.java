package com.sirius.demo.easypoi.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName CDKInfo.java
 * @Description TODO
 * @createTime 2022年08月05日 10:06:00
 */
@Data
@ToString
public class CDKInfo  implements java.io.Serializable {
    public String getCdkey() {
        return cdkey;
    }

    public void setCdkey(String cdkey) {
        this.cdkey = cdkey;
    }

    public String getGame_userid() {
        return game_userid;
    }

    public void setGame_userid(String game_userid) {
        this.game_userid = game_userid;
    }

    public int getUsercount() {
        return usercount;
    }

    public void setUsercount(int usercount) {
        this.usercount = usercount;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public String getDuihuanTime() {
        return duihuanTime;
    }

    public void setDuihuanTime(String duihuanTime) {
        this.duihuanTime = duihuanTime;
    }
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public MsgClientGroup getGroup() {
        return group;
    }

    public void setGroup(MsgClientGroup group) {
        this.group = group;
    }

    public CDKInfo() {
    }

    /**
     * name 指定导出excel是生成的列名
     * orderNum可指定导出的该属性对应的所在列的位置
     * width设置单元格宽度
     * type设置导出类型 1是文本 2是图片 3是函数 10数字 默认是文本
     */

    private String cdkey;

    private String game_userid;

    private int usercount;

    private String gift;

    private String mark;

    private String duihuanTime;

    private MsgClientGroup  group;


}

