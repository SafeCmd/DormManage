package com.tdysj.dorm.common.security.utils;

import com.tdysj.dorm.common.security.entity.JwtUser;
import com.tdysj.dorm.common.security.service.UserDetailsServiceImpl;
import com.tdysj.dorm.modules.upms.entity.TbUser;
import com.tdysj.dorm.modules.upms.service.ITbUserService;
import com.tdysj.dorm.modules.upms.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Create by yachtcay
 * @date 2019/7/18 11:06
 */
@Component
public class UserUtils {

    private static UserDetailsServiceImpl userDetailsService;

    private static ITbUserService sysUserService;

    @Autowired
    public void setUserDetailsService(UserDetailsServiceImpl userDetailsService) {
        UserUtils.userDetailsService = userDetailsService;
    }

    @Autowired
    public void setSysUserService(ITbUserService sysUserService) {
        UserUtils.sysUserService = sysUserService;
    }

    public static JwtUser getCurrentUser() {
        return (JwtUser) userDetailsService.loadUserByUsername(getCurrentUserName());
    }

    /**
     * TODO:由于在JWTAuthorizationFilter这个类注入UserDetailsServiceImpl一致失败，
     * 导致无法正确查找到用户，所以存入Authentication的Principal为从 token 中取出的当前用户的姓名
     */
    private static String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            return (String) authentication.getPrincipal();
        }
        return null;
    }

    /**
     * 获取当前登录用户的id
     *
     * @return
     */
    public static String getNowUserId() {
        return getCurrentUser().getId();
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
    public static UserVo getNowUserVo() {
        return sysUserService.getUserVoById(getNowUserId());
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
    public static TbUser getNowUser() {
        return sysUserService.getById(getNowUserId());
    }
}
