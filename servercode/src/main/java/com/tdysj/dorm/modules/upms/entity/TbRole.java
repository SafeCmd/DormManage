package com.tdysj.dorm.modules.upms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 角色表 
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_role")
@ApiModel(value="TbRole对象", description="角色表 ")
public class TbRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId("ID")
    private String id;

    @ApiModelProperty(value = "角色名")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "角色标识")
    @TableField("ROLE_Sign")
    private String roleSign;


}
