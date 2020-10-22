package com.tdysj.dorm.modules.main.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tdysj.dorm.common.enums.ResultEnums;
import com.tdysj.dorm.common.utils.R;
import com.tdysj.dorm.modules.main.entity.TbBuilding;
import com.tdysj.dorm.modules.main.service.ITbBuildingService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 宿舍楼栋表  前端控制器
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@RestController
@AllArgsConstructor
@RequestMapping("/main/tb-building")
public class TbBuildingController {
    private  final ITbBuildingService buildingService;

    /**
     * 根据id获取楼栋信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id获取楼栋")
    R<TbBuilding> getById(@PathVariable Integer id){
       return R.ok(ResultEnums.SUCCESS,buildingService.getById(id));
    }

    @GetMapping("/list")
    @ApiOperation("获取楼栋列表")
    public R list() {
        return R.ok(ResultEnums.SUCCESS, buildingService.list(Wrappers.<TbBuilding>emptyWrapper().lambda().orderByDesc(TbBuilding::getCreatedTime)));
    }

    /**
     * 保存设备
     *
     * @param building
     * @return
     */
    @PostMapping
    @ApiOperation("保存楼栋信息")
    @PreAuthorize("@ps.hasPermission('dorm:building:save')")
    public R save(@Valid @RequestBody TbBuilding building) {

        if (buildingService.save(building)) {
            return R.ok(ResultEnums.BUILDING_SAVE_FAIL);
        }
        return R.error(ResultEnums.BUILDING_DELETE_FAIL);
    }

    /**
     * 根据id修改设备
     * @param building
     * @return
     */
    @PutMapping
    @ApiOperation("修改楼栋信息")
    @PreAuthorize("@ps.hasPermission('dorm:building:update')")
    public R update(@Valid @RequestBody TbBuilding building) {
        if (buildingService.updateById(building)) {
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
    @ApiOperation("删除楼栋")
    @PreAuthorize("@ps.hasPermission('dorm:building:delete')")
    public R remove(@PathVariable Integer id) {
        if (buildingService.removeById(id)) {
            return R.ok(ResultEnums.SUCCESS);
        }
        return R.error(ResultEnums.BUILDING_DELETE_FAIL);
    }
}
