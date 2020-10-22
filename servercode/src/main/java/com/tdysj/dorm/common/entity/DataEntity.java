package com.tdysj.dorm.common.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tdysj.dorm.common.constant.CommonConstants;
import com.tdysj.dorm.common.utils.IdUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author Create by yachtcay
 * @date 2019/3/1 11:29
 */
@Data
public abstract class DataEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 创建者
     */
    @ApiModelProperty("创建者")
    protected String createdBy;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建日期")
    protected Date createdTime;

    /**
     * 更新者
     */
    @ApiModelProperty("更新者")
    protected String updatedBy;

    /**
     * 更新日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新日期")
    protected Date updatedTime;

    /**
     * 删除标记（0：正常；1：删除）
     */
    @TableLogic
    @ApiModelProperty("删除标记（0：正常；1：删除）")
    protected String delFlag;

    /**
     * 备注
     */
    protected String remarks;

    public DataEntity() {
        super();
        this.delFlag = CommonConstants.STATUS_NORMAL;
    }

    public DataEntity(String id) {
        super(id);
    }

    /**
     * 插入之前执行方法，子类实现
     */
    @Override
    public void preInsert(String userId) {
        setId(IdUtil.snowflakeId());
        if (StringUtils.isNotBlank(userId)){
            this.updatedBy = userId;
            this.createdBy = userId;
        }
        this.updatedTime = new Date();
        this.createdTime = this.updatedTime;
    }

    /**
     * 更新之前执行方法，子类实现
     */
    @Override
    public void preUpdate(String userId) {
        if (StringUtils.isNotBlank(userId)){
            this.updatedBy = userId;
        }
        this.updatedTime = new Date();
    }

}
