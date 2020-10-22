package com.tdysj.dorm.modules.main.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tdysj.dorm.common.entity.DataEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 宿舍楼栋表 
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@Data
@TableName("tb_building")
@EqualsAndHashCode(callSuper = true)
public class TbBuilding extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "楼号")
    @TableField("NO")
    private String no;

    @ApiModelProperty(value = "宿舍编号")
    @TableField("DROM_NAME")
    private String dromName;

    @ApiModelProperty(value = "宿舍电话")
    @TableField("DROM_PHONE")
    private Integer dromPhone;

    @ApiModelProperty(value = "可住人数")
    @TableField("TOTAL")
    private Integer total;

    @ApiModelProperty(value = "已住人数")
    @TableField("USED")
    private Integer used;

}
