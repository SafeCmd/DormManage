package com.tdysj.dorm.modules.upms.vo;

import com.tdysj.dorm.common.security.constants.SecurityConstants;
import com.tdysj.dorm.modules.upms.entity.TbRole;
import com.tdysj.dorm.modules.upms.entity.TbUser;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserVo extends TbUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<TbRole> roleList;

    public List<SimpleGrantedAuthority> getSysRoleLists() {
        return roleList.stream().map(sysRole ->
                new SimpleGrantedAuthority(SecurityConstants.ROLE_PREFIX + sysRole.getRoleSign())).collect(Collectors.toList());
    }
}
