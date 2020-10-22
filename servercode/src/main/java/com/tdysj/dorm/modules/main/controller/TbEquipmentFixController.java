package com.tdysj.dorm.modules.main.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tdysj.dorm.common.enums.ResultEnums;
import com.tdysj.dorm.common.utils.R;
import com.tdysj.dorm.modules.main.entity.TbBuilding;
import com.tdysj.dorm.modules.main.entity.TbEquipment;
import com.tdysj.dorm.modules.main.entity.TbEquipmentFix;
import com.tdysj.dorm.modules.main.service.ITbEquipmentFixService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 设备报修表  前端控制器
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@RestController
@AllArgsConstructor
@RequestMapping("/main/tb-equipment-fix")
public class TbEquipmentFixController {

    private  final ITbEquipmentFixService equipmentFixService;
    /**
     * 根据id获取设备报修信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id获取设备报修")
    R<TbBuilding> getById(@PathVariable Integer id){
        return R.ok(ResultEnums.SUCCESS,equipmentFixService.getById(id));
    }

    @GetMapping("/list")
    @ApiOperation("获取设备报修列表")
    public R list() {
        return R.ok(ResultEnums.SUCCESS, equipmentFixService.list(Wrappers.<TbEquipmentFix>emptyWrapper().lambda().orderByDesc(TbEquipmentFix::getCreatedTime)));
    }

    /**
     * 保存设备
     *  @param equipmentFix
     * @return
     */
    @PostMapping
    @ApiOperation("保存设备报修信息")
    @PreAuthorize("@ps.hasPermission('dorm:equipmentFix:save')")
    public R save(@Valid @RequestBody TbEquipmentFix equipmentFix) {

        if (equipmentFixService.save(equipmentFix)) {
            return R.ok(ResultEnums.SAVE_FAIL);
        }
        return R.error(ResultEnums.DELETE_FAIL);
    }

    /**
     * 根据id修改设备报修
     * @param equipmentFix
     * @return
     */
    @PutMapping
    @ApiOperation("修改设备信报修息")
    @PreAuthorize("@ps.hasPermission('dorm:equipment:update')")
    public R update(@Valid @RequestBody TbEquipmentFix equipmentFix) {
        if (equipmentFixService.updateById(equipmentFix)) {
            return R.ok(ResultEnums.SUCCESS);
        }
        return R.error(ResultEnums.UPDATE_FAIL);
    }

    /**
     * 根据id删除设备
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation("删除设备报修信息")
    @PreAuthorize("@ps.hasPermission('dorm:equipment:delete')")
    public R remove(@PathVariable Integer id) {
        if (equipmentFixService.removeById(id)) {
            return R.ok(ResultEnums.SUCCESS);
        }
        return R.error(ResultEnums.DELETE_FAIL);
    }
}
