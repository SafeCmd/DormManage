package com.tdysj.dorm.modules.main.entity;

import java.math.BigDecimal;
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
 * 设备报修表 
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_equipment_fix")
@ApiModel(value="TbEquipmentFix对象", description="设备报修表 ")
public class TbEquipmentFix implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId("ID")
    private Integer id;

    @ApiModelProperty(value = "宿舍编号")
    @TableField("DORM_NO")
    private String dormNo;

    @ApiModelProperty(value = "设备编号")
    @TableField("EQ_NO")
    private String eqNo;

    @ApiModelProperty(value = "报修原因")
    @TableField("REPAIR_REASON")
    private String repairReason;

    @ApiModelProperty(value = "上报时间")
    @TableField("SUB_TIME")
    private Date subTime;

    @ApiModelProperty(value = "处理时间")
    @TableField("HANDLE_TIME")
    private Date handleTime;

    @ApiModelProperty(value = "报修金额")
    @TableField("COST")
    private BigDecimal cost;

    @ApiModelProperty(value = "技术野生菌")
    @TableField("REVISION")
    private Integer revision;

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
