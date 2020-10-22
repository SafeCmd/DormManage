package com.tdysj.dorm.modules.upms.controller;


import com.tdysj.dorm.common.utils.IdUtil;
import com.tdysj.dorm.common.utils.R;
import com.tdysj.dorm.modules.upms.dto.UserDto;
import com.tdysj.dorm.modules.upms.entity.TbUser;
import com.tdysj.dorm.modules.upms.service.ITbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 管理员信息表  前端控制器
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@Api(description = "用户")
@RestController
@RequestMapping("/sys/user")
@AllArgsConstructor
public class TbUserController {
 private  final ITbUserService iTbUserService;

    /**
     * 增加管理员用户
     * @param userDto
     * @return
     */
 @ApiOperation("保存用户")
 @PreAuthorize("@ps.hasPermission('sys:user:save')")
 @PostMapping
 public R save(@Valid @RequestBody UserDto userDto){
   return  R.ok(iTbUserService.saveUser(userDto));
 }
}
