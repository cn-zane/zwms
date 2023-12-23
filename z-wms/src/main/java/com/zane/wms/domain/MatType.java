package com.zane.wms.domain;

import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 物料类型对象 wms_base_mat_type
 *
 * @author zane
 */
@ApiModel(description="物料类型对象")
@Data
@TableName("wms_base_mat_type")
public class MatType {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("物料类型id")
    private Long matTypeId;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改人")
    private String updateBy;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("物料类型名称")
    @Excel(name = "物料类型名称")
    private String matTypeName;

    @ApiModelProperty("排序")
    @Excel(name = "排序")
    private Integer sort;

    @ApiModelProperty("状态（0正常 1停用）")
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private Integer status;

    @ApiModelProperty("删除标识")
    private Integer delFlag;

    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String remark;

}
