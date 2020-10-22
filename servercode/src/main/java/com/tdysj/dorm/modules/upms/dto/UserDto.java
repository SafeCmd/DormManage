package com.tdysj.dorm.modules.upms.dto;

import com.tdysj.dorm.modules.upms.entity.TbUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends TbUser {
    /**
     * 角色List
     */
    private List<String> roleList;

    /**
     * 新密码
     */
    private String newPassword;
}
