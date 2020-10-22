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
 * 设备租凭表 
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_equipment")
@ApiModel(value="TbEquipment对象", description="设备租凭表 ")
public class TbEquipment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId("ID")
    private Integer id;

    @ApiModelProperty(value = "设备编号")
    @TableField("NO")
    private String no;

    @ApiModelProperty(value = "设备名称")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "租凭人编号")
    @TableField("RENT_STUDEN_NO")
    private String rentStudenNo;

    @ApiModelProperty(value = "租凭日期")
    @TableField("RENT_TIME")
    private Date rentTime;

    @ApiModelProperty(value = "归还日期")
    @TableField("RETURN_TIME")
    private Date returnTime;

    @ApiModelProperty(value = "租凭费用")
    @TableField("RENT_COST")
    private BigDecimal rentCost;

    @ApiModelProperty(value = "备注信息")
    @TableField("REMARK")
    private String remark;

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
