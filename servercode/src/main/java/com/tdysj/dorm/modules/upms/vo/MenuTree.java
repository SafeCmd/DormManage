package com.tdysj.dorm.modules.upms.vo;

import com.tdysj.dorm.common.utils.TreeNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单树形结构
 *
 * @author Create by yachtcay
 * @date 2019/7/19 11:45
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuTree extends TreeNode {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称
     */
    private String name;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 菜单URL
     */
    private String url;
    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String permission;
    /**
     * 类型(0:目录,1:菜单,2:按钮)
     */
    private String type;
    /**
     * 图标
     */
    private String icon;
}
