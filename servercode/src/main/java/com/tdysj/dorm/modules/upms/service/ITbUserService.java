package com.tdysj.dorm.modules.upms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tdysj.dorm.common.utils.R;
import com.tdysj.dorm.modules.upms.dto.UserDto;
import com.tdysj.dorm.modules.upms.entity.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tdysj.dorm.modules.upms.vo.UserVo;

/**
 * <p>
 * 管理员信息表  服务类
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
public interface ITbUserService extends IService<TbUser> {
    /**
     * 根据id获取用户数据
     *
     * @param id 用户id
     * @return
     */
    UserVo getUserVoById(String id);

    /**
     * 根据用户名查询用户数据
     *
     * @param username 用户名
     * @return
     */
    UserVo getUserVoByUsername(String username);

    /**
     * 查询用户分页数据
     *
     * @param page    分页参数
     * @param sysUser 查询参数
     * @return
     */
    IPage selectUserPage(Page page, TbUser sysUser);

    /**
     * 保存用户
     *
     * @param sysUserDto 用户对象
     * @return
     */
    R saveUser(UserDto sysUserDto);

    /**
     * 修改用户
     *
     * @param sysUserDto 用户对象
     * @return
     */
    R updateUser(UserDto sysUserDto);

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return
     */
    R removeUser(String id);
}
