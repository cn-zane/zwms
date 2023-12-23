package com.zane.wms.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 物料类型 查询 对象
 *
 * @author zane
 */
@ApiModel(description="物料类型 查询 对象")
@Data
public class MatTypeQuery {
    @ApiModelProperty("物料类型名称 精确匹配")
    private String matTypeNameLike;

    @ApiModelProperty("排序 精确匹配")
    private Integer sort;

    @ApiModelProperty("状态（0正常 1停用） 精确匹配")
    private Integer status;

}
