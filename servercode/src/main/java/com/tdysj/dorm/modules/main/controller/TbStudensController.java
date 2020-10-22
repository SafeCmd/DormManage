package com.tdysj.dorm.modules.main.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tdysj.dorm.common.enums.ResultEnums;
import com.tdysj.dorm.common.utils.R;
import com.tdysj.dorm.modules.main.entity.TbBuilding;
import com.tdysj.dorm.modules.main.entity.TbEwcost;
import com.tdysj.dorm.modules.main.entity.TbStudens;
import com.tdysj.dorm.modules.main.service.ITbStudensService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 学生信息表 记录住宿学生基本信息的表 前端控制器
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@RestController
@AllArgsConstructor
@RequestMapping("/main/tb-studens")
public class TbStudensController {

    private  final ITbStudensService studensService;

    /**
     * 根据id学生信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id获取学生信息")
    R<TbBuilding> getById(@PathVariable Integer id){
        return R.ok(ResultEnums.SUCCESS,studensService.getById(id));
    }

    @GetMapping("/list")
    @ApiOperation("获取学生信息")
    public R list() {
        return R.ok(ResultEnums.SUCCESS, studensService.list(Wrappers.<TbStudens>emptyWrapper().lambda().orderByDesc(TbStudens::getCreatedTime)));
    }

    /**
     * 保存学生信息
     *  @param studens
     * @return
     */
    @PostMapping
    @ApiOperation("保存学生信息")
    @PreAuthorize("@ps.hasPermission('dorm:studens:save')")
    public R save(@Valid @RequestBody TbStudens studens) {

        if (studensService.save(studens)) {
            return R.ok(ResultEnums.SAVE_FAIL);
        }
        return R.error(ResultEnums.DELETE_FAIL);
    }

    /**
     * 根据id修改学生信息
     * @param studens
     * @return
     */
    @PutMapping
    @ApiOperation("修改学生信息")
    @PreAuthorize("@ps.hasPermission('dorm:studens:update')")
    public R update(@Valid @RequestBody TbStudens studens) {
        if (studensService.updateById(studens)) {
            return R.ok(ResultEnums.SUCCESS);
        }
        return R.error(ResultEnums.UPDATE_FAIL);
    }

    /**
     * 根据id删除学生信息
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation("删除学生信息")
    @PreAuthorize("@ps.hasPermission('dorm:studens:delete')")
    public R remove(@PathVariable Integer id) {
        if (studensService.removeById(id)) {
            return R.ok(ResultEnums.SUCCESS);
        }
        return R.error(ResultEnums.DELETE_FAIL);
    }
}
