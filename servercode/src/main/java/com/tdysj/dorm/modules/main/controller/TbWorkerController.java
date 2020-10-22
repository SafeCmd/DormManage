package com.tdysj.dorm.modules.main.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tdysj.dorm.common.enums.ResultEnums;
import com.tdysj.dorm.common.utils.R;
import com.tdysj.dorm.modules.main.entity.TbBuilding;
import com.tdysj.dorm.modules.main.entity.TbVisitor;
import com.tdysj.dorm.modules.main.entity.TbWorker;
import com.tdysj.dorm.modules.main.service.ITbWorkerService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 宿舍员工表  前端控制器
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@RestController
@AllArgsConstructor
@RequestMapping("/main/tb-worker")
public class TbWorkerController {
    private  final ITbWorkerService workerService;

    /**
     * 根据id获取工作人员
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id工作人员信息")
    R<TbBuilding> getById(@PathVariable Integer id){
        return R.ok(ResultEnums.SUCCESS,workerService.getById(id));
    }

    @GetMapping("/list")
    @ApiOperation("获取工作人员信息")
    public R list() {
        return R.ok(ResultEnums.SUCCESS, workerService.list(Wrappers.<TbWorker>emptyWrapper().lambda().orderByDesc(TbWorker::getCreatedTime)));
    }

    /**
     * 保存工作人员信息
     *  @param worker
     * @return
     */
    @PostMapping
    @ApiOperation("保存工作人员信息")
    @PreAuthorize("@ps.hasPermission('dorm:worker:save')")
    public R save(@Valid @RequestBody TbWorker worker) {

        if (workerService.save(worker)) {
            return R.ok(ResultEnums.SAVE_FAIL);
        }
        return R.error(ResultEnums.DELETE_FAIL);
    }

    /**
     * 根据id修改工作人员信息
     * @param worker
     * @return
     */
    @PutMapping
    @ApiOperation("修改工作人员信息")
    @PreAuthorize("@ps.hasPermission('dorm:worker:update')")
    public R update(@Valid @RequestBody TbWorker worker) {
        if (workerService.updateById(worker)) {
            return R.ok(ResultEnums.SUCCESS);
        }
        return R.error(ResultEnums.UPDATE_FAIL);
    }

    /**
     * 根据id删除工作人员信息
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation("删除工作人员信息")
    @PreAuthorize("@ps.hasPermission('dorm:worker:delete')")
    public R remove(@PathVariable Integer id) {
        if (workerService.removeById(id)) {
            return R.ok(ResultEnums.SUCCESS);
        }
        return R.error(ResultEnums.DELETE_FAIL);
    }
}
