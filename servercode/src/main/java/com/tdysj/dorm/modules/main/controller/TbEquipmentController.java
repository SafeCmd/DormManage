package com.tdysj.dorm.modules.main.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tdysj.dorm.common.enums.ResultEnums;
import com.tdysj.dorm.common.utils.R;
import com.tdysj.dorm.modules.main.entity.TbBuilding;
import com.tdysj.dorm.modules.main.entity.TbEquipment;
import com.tdysj.dorm.modules.main.service.ITbEquipmentService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 设备租凭表  前端控制器
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@RestController
@AllArgsConstructor
@RequestMapping("/main/tb-equipment")
public class TbEquipmentController {

    private final ITbEquipmentService equipmentService;
    /**
     * 根据id获取楼栋信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id获取设备")
    R<TbBuilding> getById(@PathVariable Integer id){
        return R.ok(ResultEnums.SUCCESS,equipmentService.getById(id));
    }

    @GetMapping("/list")
    @ApiOperation("获取设备列表")
    public R list() {
        return R.ok(ResultEnums.SUCCESS, equipmentService.list(Wrappers.<TbEquipment>emptyWrapper().lambda().orderByDesc(TbEquipment::getCreatedTime)));
    }

    /**
     * 保存设备
     *  @param equipment
     * @return
     */
    @PostMapping
    @ApiOperation("保存设备信息")
    @PreAuthorize("@ps.hasPermission('dorm:equipment:save')")
    public R save(@Valid @RequestBody TbEquipment equipment) {

        if (equipmentService.save(equipment)) {
            return R.ok(ResultEnums.BUILDING_SAVE_FAIL);
        }
        return R.error(ResultEnums.BUILDING_DELETE_FAIL);
    }

    /**
     * 根据id修改设备
     * @param equipment
     * @return
     */
    @PutMapping
    @ApiOperation("修改设备信息")
    @PreAuthorize("@ps.hasPermission('dorm:equipment:update')")
    public R update(@Valid @RequestBody TbEquipment equipment) {
        if (equipmentService.updateById(equipment)) {
            return R.ok(ResultEnums.SUCCESS);
        }
        return R.error(ResultEnums.BUILDING_UPDATE_FAIL);
    }

    /**
     * 根据id删除设备
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation("删除设备")
    @PreAuthorize("@ps.hasPermission('dorm:equipment:delete')")
    public R remove(@PathVariable Integer id) {
        if (equipmentService.removeById(id)) {
            return R.ok(ResultEnums.SUCCESS);
        }
        return R.error(ResultEnums.BUILDING_DELETE_FAIL);
    }
}
