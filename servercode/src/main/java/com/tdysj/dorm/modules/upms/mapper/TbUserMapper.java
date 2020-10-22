package com.tdysj.dorm.modules.upms.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tdysj.dorm.modules.upms.entity.TbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tdysj.dorm.modules.upms.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 管理员信息表  Mapper 接口
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
public interface TbUserMapper extends BaseMapper<TbUser> {
    /**
     * 根据id获取用户数据
     *
     * @param id 用户id
     * @return
     */
//    UserVo getUserVoById(@Param("id") String id);

    /**
     * 根据用户名查询用户数据
     *
     * @param username 用户名
     * @return
     */
    UserVo getUserVoByUsername(@Param("username") String username);

    /**
     * 查询用户分页列表
     *
     * @param page    分页参数
     * @param sysUser 查询参数
     * @return
     */
//    IPage<List<UserVo>> selectUserPage(Page page, @Param("query") SysUser sysUser);
}
