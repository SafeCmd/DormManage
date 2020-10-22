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
 * 用户角色表 
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_user_role")
@ApiModel(value="TbUserRole对象", description="用户角色表 ")
public class TbUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId("ID")
    private String id;

    @ApiModelProperty(value = "用户ID")
    @TableField("USER_ID")
    private String userId;

    @ApiModelProperty(value = "角色ID")
    @TableField("ROLE_ID")
    private String roleId;


}
