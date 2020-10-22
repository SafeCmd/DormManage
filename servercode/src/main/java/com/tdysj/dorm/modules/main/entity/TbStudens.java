package com.tdysj.dorm.modules.main.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学生信息表 记录住宿学生基本信息的表
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_studens")
@ApiModel(value="TbStudens对象", description="学生信息表 记录住宿学生基本信息的表")
public class TbStudens implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId("ID")
    private String id;

    @ApiModelProperty(value = "学号")
    @TableField("NO")
    private String no;

    @ApiModelProperty(value = "姓名")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "性别")
    @TableField("GENDER")
    private String gender;

    @ApiModelProperty(value = "技术野生菌")
    @TableField("REVISION")
    private Integer revision;

    @ApiModelProperty(value = "专业")
    @TableField("SPECIALITIES")
    private String specialities;

    @ApiModelProperty(value = "联系方式")
    @TableField("PHONE")
    private String phone;

    @ApiModelProperty(value = "创建人")
    @TableField("CREATED_BY")
    private String createdBy;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_TIME")
    private Date createdTime;

    @ApiModelProperty(value = "更新人")
    @TableField("UPDATED_BY")
    private String updatedBy;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATED_TIME")
    private Date updatedTime;


}
