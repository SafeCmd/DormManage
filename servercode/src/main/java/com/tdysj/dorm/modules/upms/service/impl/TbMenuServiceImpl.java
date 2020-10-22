package com.tdysj.dorm.modules.upms.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tdysj.dorm.common.constant.CommonConstants;
import com.tdysj.dorm.common.utils.R;
import com.tdysj.dorm.common.utils.TreeUtil;
import com.tdysj.dorm.modules.upms.entity.TbMenu;
import com.tdysj.dorm.modules.upms.mapper.TbMenuMapper;
import com.tdysj.dorm.modules.upms.service.ITbMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tdysj.dorm.modules.upms.vo.MenuTree;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单表  服务实现类
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@Service
public class TbMenuServiceImpl extends ServiceImpl<TbMenuMapper, TbMenu> implements ITbMenuService {

    @Override
    public List<MenuTree> listMenuTrees() {
        return getMenuTree(this.list(Wrappers.<TbMenu>query().lambda().orderByAsc(TbMenu::getSort)));
    }
    /**
     * 构建菜单树
     *
     * @param menus 菜单list
     * @return
     */
    private List<MenuTree> getMenuTree(List<TbMenu> menus) {
        List<MenuTree> treeList = menus.stream().filter(menu -> !menu.getId().equals(menu.getParentId())).map(menu -> {
            MenuTree node = new MenuTree();
            node.setId(menu.getId());
            node.setParentId(menu.getParentId());
            node.setName(menu.getName());
            node.setSort(menu.getSort());
            node.setPermission(menu.getPermission());
            node.setIcon(menu.getIcon());
            node.setType(menu.getType());
            node.setUrl(menu.getUrl());
            return node;
        }).collect(Collectors.toList());
        return TreeUtil.buildByLoop(treeList, CommonConstants.TOP_NODE);
    }
    @Override
    public R removeMenuById(String id) {
        return null;
    }

    @Override
    public List<String> listPermissionByRoleIds(String roleIds) {
        return baseMapper.listPermissionByRoleIds(roleIds);
    }
}
