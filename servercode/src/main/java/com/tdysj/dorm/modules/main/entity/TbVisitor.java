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
 * 访客登记表 
 * </p>
 *
 * @author mr
 * @since 2020-06-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_visitor")
@ApiModel(value="TbVisitor对象", description="访客登记表 ")
public class TbVisitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId("ID")
    private Integer id;

    @ApiModelProperty(value = "来访者姓名")
    @TableField("VISITOR_NAME")
    private String visitorName;

    @ApiModelProperty(value = "被访者姓名")
    @TableField("RESPONDENTS_NAME")
    private String respondentsName;

    @ApiModelProperty(value = "与被访人关系")
    @TableField("RELATION")
    private String relation;

    @ApiModelProperty(value = "证件类型")
    @TableField("CAR_TYPE")
    private String carType;

    @ApiModelProperty(value = "证件号码")
    @TableField("CAR_NO")
    private String carNo;

    @ApiModelProperty(value = "来访时间")
    @TableField("VISITOR_TIME")
    private Date visitorTime;

    @ApiModelProperty(value = "离开时间")
    @TableField("LEVE_TIME")
    private Date leveTime;

    @ApiModelProperty(value = "备注")
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
