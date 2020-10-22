package com.tdysj.dorm.modules.upms.mapper;

import com.tdysj.dorm.modules.upms.entity.TbMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单表  Mapper 接口
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
public interface TbMenuMapper extends BaseMapper<TbMenu> {
    /**
     * 根据角色获取方法权限
     *
     * @param roleIds 角色ids
     * @return
     */
    List<String> listPermissionByRoleIds(@Param("roleIds") String roleIds);
}
