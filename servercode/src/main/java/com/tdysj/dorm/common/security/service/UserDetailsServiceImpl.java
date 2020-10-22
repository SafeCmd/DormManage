package com.tdysj.dorm.common.security.service;

import com.tdysj.dorm.common.constant.CommonConstants;
import com.tdysj.dorm.common.security.entity.JwtUser;
import com.tdysj.dorm.modules.upms.service.ITbMenuService;
import com.tdysj.dorm.modules.upms.service.ITbUserService;
import com.tdysj.dorm.modules.upms.vo.UserVo;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private ITbUserService sysUserService;

    private ITbMenuService sysMenuService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo userVo = sysUserService.getUserVoByUsername(username);
        if (userVo == null) {
            throw new UsernameNotFoundException("No user found with username " + username);
        }
        String roleIds = StringUtils.join(userVo.getRoleList().stream().map(sysRole -> sysRole.getId()).collect(Collectors.toList()), CommonConstants.COMMA);
        List<String> permissionLists = sysMenuService.listPermissionByRoleIds(roleIds);
        return new JwtUser(userVo, permissionLists.stream().map(permission -> new SimpleGrantedAuthority(permission)).collect(Collectors.toList()));
    }
}
