package com.tdysj.dorm.modules.main.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tdysj.dorm.common.enums.ResultEnums;
import com.tdysj.dorm.common.utils.R;
import com.tdysj.dorm.modules.main.entity.TbBuilding;
import com.tdysj.dorm.modules.main.entity.TbEwcost;
import com.tdysj.dorm.modules.main.service.ITbEwcostService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 水电计费表  前端控制器
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@RestController
@AllArgsConstructor
@RequestMapping("/main/tb-ewcost")
public class TbEwcostController {

private  final ITbEwcostService ewcostService;
    /**
     * 根据id获水电费
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id获取设备报修")
    R<TbBuilding> getById(@PathVariable Integer id){
        return R.ok(ResultEnums.SUCCESS,ewcostService.getById(id));
    }

    @GetMapping("/list")
    @ApiOperation("获取设备报修列表")
    public R list() {
        return R.ok(ResultEnums.SUCCESS, ewcostService.list(Wrappers.<TbEwcost>emptyWrapper().lambda().orderByDesc(TbEwcost::getCreatedTime)));
    }

    /**
     * 保存设备
     *  @param ewcost
     * @return
     */
    @PostMapping
    @ApiOperation("保存水电费")
    @PreAuthorize("@ps.hasPermission('dorm:equipmentFix:save')")
    public R save(@Valid @RequestBody TbEwcost ewcost) {

        if (ewcostService.save(ewcost)) {
            return R.ok(ResultEnums.SAVE_FAIL);
        }
        return R.error(ResultEnums.DELETE_FAIL);
    }

    /**
     * 根据id修改水电费
     * @param ewcost
     * @return
     */
    @PutMapping
    @ApiOperation("修改水电费")
    @PreAuthorize("@ps.hasPermission('dorm:equipment:update')")
    public R update(@Valid @RequestBody TbEwcost ewcost) {
        if (ewcostService.updateById(ewcost)) {
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
    @ApiOperation("删除水电费")
    @PreAuthorize("@ps.hasPermission('dorm:equipment:delete')")
    public R remove(@PathVariable Integer id) {
        if (ewcostService.removeById(id)) {
            return R.ok(ResultEnums.SUCCESS);
        }
        return R.error(ResultEnums.DELETE_FAIL);
    }
}
