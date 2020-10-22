package com.tdysj.dorm.modules.main.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tdysj.dorm.common.enums.ResultEnums;
import com.tdysj.dorm.common.utils.R;
import com.tdysj.dorm.modules.main.entity.TbBuilding;
import com.tdysj.dorm.modules.main.entity.TbVisitor;
import com.tdysj.dorm.modules.main.service.ITbVisitorService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 访客登记表  前端控制器
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@RestController
@AllArgsConstructor
@RequestMapping("/main/tb-visitor")
public class TbVisitorController {

    private  final ITbVisitorService visitorService;
    /**
     * 根据id获取访客信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id访客信息")
    R<TbBuilding> getById(@PathVariable Integer id){
        return R.ok(ResultEnums.SUCCESS,visitorService.getById(id));
    }

    @GetMapping("/list")
    @ApiOperation("获取访客信息")
    public R list() {
        return R.ok(ResultEnums.SUCCESS, visitorService.list(Wrappers.<TbVisitor>emptyWrapper().lambda().orderByDesc(TbVisitor::getCreatedTime)));
    }

    /**
     * 保存访客信息
     *  @param visitor
     * @return
     */
    @PostMapping
    @ApiOperation("保存访客信息")
    @PreAuthorize("@ps.hasPermission('dorm:visitor:save')")
    public R save(@Valid @RequestBody TbVisitor visitor) {

        if (visitorService.save(visitor)) {
            return R.ok(ResultEnums.SAVE_FAIL);
        }
        return R.error(ResultEnums.DELETE_FAIL);
    }

    /**
     * 根据id修改学生信息
     * @param visitor
     * @return
     */
    @PutMapping
    @ApiOperation("修改访客信息")
    @PreAuthorize("@ps.hasPermission('dorm:visitor:update')")
    public R update(@Valid @RequestBody TbVisitor visitor) {
        if (visitorService.updateById(visitor)) {
            return R.ok(ResultEnums.SUCCESS);
        }
        return R.error(ResultEnums.UPDATE_FAIL);
    }

    /**
     * 根据id删除访客信息
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation("删除访客信息")
    @PreAuthorize("@ps.hasPermission('dorm:visitor:delete')")
    public R remove(@PathVariable Integer id) {
        if (visitorService.removeById(id)) {
            return R.ok(ResultEnums.SUCCESS);
        }
        return R.error(ResultEnums.DELETE_FAIL);
    }
}
