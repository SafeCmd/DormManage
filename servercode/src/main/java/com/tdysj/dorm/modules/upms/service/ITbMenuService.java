package com.tdysj.dorm.modules.upms.service;

import com.tdysj.dorm.common.utils.R;
import com.tdysj.dorm.modules.upms.entity.TbMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tdysj.dorm.modules.upms.vo.MenuTree;

import java.util.List;

/**
 * <p>
 * 菜单表  服务类
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
public interface ITbMenuService extends IService<TbMenu> {
    /**
     * 获取菜单树
     *
     * @return
     */
    List<MenuTree> listMenuTrees();

    /**
     * 根据id删除菜单
     *
     * @param id 菜单id
     * @return
     */
    R removeMenuById(String id);

    /**
     * 根据角色获取方法权限
     *
     * @param roleIds 角色ids
     * @return
     */
    List<String> listPermissionByRoleIds(String roleIds);
}
