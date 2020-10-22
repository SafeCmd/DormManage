package com.tdysj.dorm.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Create by yachtcay
 * @date 2019/3/1 11:29
 */
@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实体编号（唯一标识）
     */
    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "实体编号（唯一标识）")
    protected String id;


    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this();
        this.id = id;
    }


    /**
     * 插入之前执行方法，子类实现
     */
    public abstract void preInsert(String userId);

    /**
     * 更新之前执行方法，子类实现
     */
    public abstract void preUpdate(String userId);

}
