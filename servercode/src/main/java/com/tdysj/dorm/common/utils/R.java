package com.tdysj.dorm.common.utils;

import com.tdysj.dorm.common.constant.CommonConstants;
import com.tdysj.dorm.common.enums.ResultEnums;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 返回实体
 *
 * @author Create by yachtcay
 * @date 2019/6/4 16:37
 */
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Integer code = CommonConstants.SUCCESS;

    @Getter
    @Setter
    private String msg = CommonConstants.SUCCESS_MESSAGE;

    @Getter
    @Setter
    private T data;

    public R() {
        super();
    }

    public R(T data) {
        super();
        this.data = data;
    }

    public R(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public R(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public R(String msg) {
        super();
        this.msg = msg;
    }

    public R(String msg, T data) {
        super();
        this.msg = msg;
        this.data = data;
    }

    public R(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = CommonConstants.FAIL;
    }
    /**
     * 成功
     * 返回 {"code": 1, "msg": "成功"}
     *
     * @return
     */
    public static R ok() {
        return new R(ResultEnums.SUCCESS.getCode(), ResultEnums.SUCCESS.getMsg());
    }

    /**
     * 成功
     * 返回 {"code": xxx, "msg": "xxxxxx"}
     *
     * @param resultEnums
     * @return
     */
    public static R ok(ResultEnums resultEnums) {
        return new R(resultEnums.getCode(), resultEnums.getMsg());
    }

    /**
     * 成功
     * 返回 {"code": 1, "msg": "成功", "data": "[data]"}
     *
     * @param data
     * @return
     */
    public static R ok(Object data) {
        return new R(ResultEnums.SUCCESS.getCode(), ResultEnums.SUCCESS.getMsg(), data);
    }

    /**
     * 成功
     * 返回 {"code": xxx, "msg": "xxxxxx", "data": "[data]"}
     *
     * @param resultEnums
     * @param data
     * @return
     */
    public static R ok(ResultEnums resultEnums, Object data) {
        return new R(resultEnums.getCode(), resultEnums.getMsg(), data);
    }


    /**
     * 失败
     * 返回 {"code": 1, "msg": "失败"}
     *
     * @return
     */
    public static R error() {
        return new R(ResultEnums.FAIL.getCode(), ResultEnums.FAIL.getMsg());
    }

    /**
     * 失败
     * 返回 {"code": xxx, "msg": "xxxxxx"}
     *
     * @param resultEnums
     * @return
     */
    public static R error(ResultEnums resultEnums) {
        return new R(resultEnums.getCode(), resultEnums.getMsg());
    }

    /**
     * 失败
     * 返回 {"code": 1, "msg": "失败", "data": "[data]"}
     *
     * @param data
     * @return
     */
    public static R error(Object data) {
        return new R(ResultEnums.FAIL.getCode(), ResultEnums.FAIL.getMsg(), data);
    }

    /**
     * 失败
     * 返回 {"code": xxx, "msg": "xxxxxx", "data": "[data]"}
     *
     * @param resultEnums
     * @param data
     * @return
     */
    public static R error(ResultEnums resultEnums, Object data) {
        return new R(resultEnums.getCode(), resultEnums.getMsg(), data);
    }

    /**
     * 失败
     * 返回 {"code": xxx, "msg": "xxxxxx"}
     *
     * @param code
     * @param msg
     * @return
     */
    public static R error(Integer code, String msg) {
        return new R(code, msg);
    }

}
