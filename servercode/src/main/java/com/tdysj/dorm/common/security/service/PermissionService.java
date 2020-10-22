package com.tdysj.dorm.common.security.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * 接口权限判断
 *
 * @author Create by yachtcay
 * @date 2020/1/2 9:52
 */
@Component("ps")
public class PermissionService {

    /**
     * 判断方法是有具有权限
     *
     * @param permission
     * @return
     */
    public boolean hasPermission(String... permission) {
        if (permission.length == 0) {
            return false;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .filter(StringUtils::hasText)
                .anyMatch(x -> PatternMatchUtils.simpleMatch(permission, x));
    }

}
