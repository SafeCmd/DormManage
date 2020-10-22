package com.tdysj.dorm.common.enums;

import com.tdysj.dorm.common.constant.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Create by yachtcay
 * @date 2019/7/18 15:57
 */
@AllArgsConstructor
public enum ResultEnums {
    SUCCESS(CommonConstants.SUCCESS, CommonConstants.SUCCESS_MESSAGE),
    FAIL(CommonConstants.FAIL, CommonConstants.FAIL_MESSAGE),


    ROLE_GET_SUCCESS(CommonConstants.SUCCESS, "角色查询成功"),
    ROLE_SAVE_SUCCESS(CommonConstants.SUCCESS, "角色保存成功"),
    ROLE_UPDATE_SUCCESS(CommonConstants.SUCCESS, "角色修改成功"),
    ROLE_DELETE_SUCCESS(CommonConstants.SUCCESS, "角色删除成功"),

    ROLE_MENU_SAVE_SUCCESS(CommonConstants.SUCCESS, "权限保存成功"),

    MENU_GET_SUCCESS(CommonConstants.SUCCESS, "菜单查询成功"),
    MENU_SAVE_SUCCESS(CommonConstants.SUCCESS, "菜单保存成功"),
    MENU_UPDATE_SUCCESS(CommonConstants.SUCCESS, "菜单修改成功"),
    MENU_DELETE_SUCCESS(CommonConstants.SUCCESS, "菜单删除成功"),

    LOG_GET_SUCCESS(CommonConstants.SUCCESS, "日志查询成功"),

    USER_GET_SUCCESS(CommonConstants.SUCCESS, "用户查询成功"),
    USER_SAVE_SUCCESS(CommonConstants.SUCCESS, "用户保存成功"),
    USER_UPDATE_SUCCESS(CommonConstants.SUCCESS, "用户修改成功"),
    USER_DELETE_SUCCESS(CommonConstants.SUCCESS, "用户删除成功"),
    USER_UPDATEHEADER_SUCCESS(CommonConstants.SUCCESS,"用户头像修改成功"),




    DEPT_GET_FAIL(CommonConstants.FAIL, "部门查询失败"),
    DEPT_SAVE_FAIL(CommonConstants.FAIL, "部门保存失败"),
    DEPT_UPDATE_FAIL(CommonConstants.FAIL, "部门修改失败"),
    DEPT_DELETE_FAIL(CommonConstants.FAIL, "部门删除失败"),
    DEPT_HAS_CHILD_FAIL(CommonConstants.FAIL, "部门含有下级, 不能删除"),

    ROLE_GET_FAIL(CommonConstants.FAIL, "角色查询失败"),
    ROLE_SAVE_FAIL(CommonConstants.FAIL, "角色保存失败"),
    ROLE_UPDATE_FAIL(CommonConstants.FAIL, "角色修改失败"),
    ROLE_DELETE_FAIL(CommonConstants.FAIL, "角色删除失败"),

    ROLE_MENU_SAVE_FAIL(CommonConstants.FAIL, "权限保存失败"),

    MENU_GET_FAIL(CommonConstants.FAIL, "菜单查询失败"),
    MENU_SAVE_FAIL(CommonConstants.FAIL, "菜单保存失败"),
    MENU_UPDATE_FAIL(CommonConstants.FAIL, "菜单修改失败"),
    MENU_DELETE_FAIL(CommonConstants.FAIL, "菜单删除失败"),
    MENU_HAS_CHILD_FAIL(CommonConstants.FAIL, "菜单含有下级, 不能删除"),

    USER_GET_FAIL(CommonConstants.FAIL, "用户查询失败"),
    USER_SAVE_FAIL(CommonConstants.FAIL, "用户保存失败"),
    USER_UPDATE_FAIL(CommonConstants.FAIL, "用户修改失败"),
    USER_DELETE_FAIL(CommonConstants.FAIL, "用户删除失败"),
    USER_UPDATEHEADER_FAIL(CommonConstants.SUCCESS,"用户头像修改失败"),



    BUILDING_GET_FAIL(CommonConstants.FAIL, "楼栋信息查询失败"),
    BUILDING_SAVE_FAIL(CommonConstants.FAIL, "楼栋信息保存失败"),
    BUILDING_UPDATE_FAIL(CommonConstants.FAIL, "楼栋信息修改失败"),
    BUILDING_DELETE_FAIL(CommonConstants.FAIL, "楼栋信息删除失败"),



    GET_SUCCESS(CommonConstants.SUCCESS, "查询成功"),
    SAVE_SUCCESS(CommonConstants.SUCCESS, "保存成功"),
    UPDATE_SUCCESS(CommonConstants.SUCCESS, "修改成功"),
    DELETE_SUCCESS(CommonConstants.SUCCESS, "删除成功"),


    GET_FAIL(CommonConstants.FAIL, "信息查询失败"),
    SAVE_FAIL(CommonConstants.FAIL, "信息保存失败"),
    UPDATE_FAIL(CommonConstants.FAIL, "信息修改失败"),
    DELETE_FAIL(CommonConstants.FAIL, "信息删除失败"),


    ;
    /**
     * 返回值
     */
    @Getter
    private Integer code;
    /**
     * 返回信息
     */
    @Getter
    private String msg;
}
