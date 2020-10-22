package com.tdysj.dorm.modules.upms.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tdysj.dorm.common.enums.ResultEnums;
import com.tdysj.dorm.common.exception.UserNameAlreadyExistException;
import com.tdysj.dorm.common.security.utils.UserUtils;
import com.tdysj.dorm.common.utils.IdUtil;
import com.tdysj.dorm.common.utils.R;
import com.tdysj.dorm.modules.upms.dto.UserDto;
import com.tdysj.dorm.modules.upms.entity.TbUser;
import com.tdysj.dorm.modules.upms.entity.TbUserRole;
import com.tdysj.dorm.modules.upms.mapper.TbUserMapper;
import com.tdysj.dorm.modules.upms.service.ITbRoleService;
import com.tdysj.dorm.modules.upms.service.ITbUserRoleService;
import com.tdysj.dorm.modules.upms.service.ITbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tdysj.dorm.modules.upms.vo.UserVo;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 管理员信息表  服务实现类
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@AllArgsConstructor
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {
    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();
    private  final ITbUserRoleService userRoleService;
    @Override
    public UserVo getUserVoById(String id) {
        return null;
    }

    @Override
    public UserVo getUserVoByUsername(String username) {
        return baseMapper.getUserVoByUsername(username);
    }

    @Override
    public IPage selectUserPage(Page page, TbUser sysUser) {
        return null;
    }


    /**
     * 保存用户
     *
     * @param sysUserDto 用户对象
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public R saveUser(UserDto sysUserDto) {
        UserVo user = getUserVoByUsername(sysUserDto.getUsername());
        if (user != null) {
            throw new UserNameAlreadyExistException("用户名已存在");
        }
        TbUser sysUser = new TbUser();
        BeanUtils.copyProperties(sysUserDto, sysUser);
        sysUser.preInsert(UserUtils.getNowUserId());
        sysUser.setPassword(ENCODER.encode(sysUserDto.getPassword()));
        baseMapper.insert(sysUser);
        if (userRoleService.saveBatch(roleIdConvertRoleUser(sysUser.getId(), sysUserDto.getRoleList()))) {
            return R.ok(ResultEnums.USER_SAVE_SUCCESS);
        }
        return R.error(ResultEnums.USER_SAVE_FAIL);
    }
    @Override
    public R updateUser(UserDto sysUserDto) {
        return null;
    }

    private List<TbUserRole> roleIdConvertRoleUser(String userId, List<String> roleIdList) {
        return roleIdList.stream().map(roleId -> {
            TbUserRole sysUserRole = new TbUserRole();
            sysUserRole.setId(IdUtil.snowflakeId());
            sysUserRole.setUserId(userId);
            sysUserRole.setRoleId(roleId);
            return sysUserRole;
        }).collect(Collectors.toList());
    }
    @Override
    public R removeUser(String id) {
        return null;
    }
}
