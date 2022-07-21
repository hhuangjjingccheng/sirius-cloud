package com.sirius.common.utils;

import com.sirius.common.constants.Constant;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.time.temporal.Temporal;
import java.util.Stack;

/**
 * 系统统一返回结果集
 * @param <T>
 */
@Getter
@Setter
public class ResultUtil<T> implements Serializable {

    /**
     * 需要被序列化的实现类，建议序列化的class都给一个序列化的ID，这样可以保证序列化的成功，版本的兼容性
     */
    private static final long serialVersionUID = 1L;

    /**
     * 成功状态码
     */
    public static final int SUCCESS = Constant.SUCCESS;

    /**
     * 失败状态码
     */
    public static final int FAIL = Constant.FAIL;

    /**
     * 结果集变量
     */
    private int code;
    private String msg;
    private T data;

    /**
     *  初始化方法
     */
    private static <T> ResultUtil<T> resultUtil(int code,String msg,T data){
        ResultUtil<T> resultUtil = new ResultUtil<>();
        resultUtil.setCode(code);
        resultUtil.setMsg(msg);
        resultUtil.setData(data);
        return resultUtil;
    }

    /**
     * 仅返回成功状态码
     * @return
     * @param <T>
     */
    public static <T> ResultUtil<T> success(){
        return resultUtil(SUCCESS,null,null);
    }

    /**
     * 返回成功状态码，数据
     * @param data
     * @return
     * @param <T>
     */
    public static <T> ResultUtil<T> success(T data){
        return resultUtil(SUCCESS,null,data);
    }

    /**
     * 返回成功状态码，成功信息，数据
     * @param data
     * @param msg
     * @return
     * @param <T>
     */
    public static <T> ResultUtil<T> success(T data,String msg){
        return resultUtil(SUCCESS,msg,data);
    }

    /**
     * 仅返回错误状态码
     * @return
     * @param <T>
     */
    public static <T> ResultUtil<T> fail(){
        return resultUtil(FAIL,null,null);
    }

    /**
     * 返回错误状态码，错误信息
     * @param msg
     * @return
     * @param <T>
     */
    public static <T> ResultUtil<T> fail(String msg){
        return resultUtil(FAIL,msg,null);
    }

    /**
     * 返回自定义错误状态码，错误信息
     * @param code
     * @param msg
     * @return
     * @param <T>
     */
    public static <T> ResultUtil<T> fail(int code,String msg){
        return resultUtil(code,msg,null);
    }

}













