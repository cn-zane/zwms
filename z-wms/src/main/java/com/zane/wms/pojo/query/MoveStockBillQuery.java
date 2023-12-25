package com.zane.wms.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 移库单 查询 对象
 *
 * @author zane
 */
@ApiModel(description="移库单 查询 对象")
@Data
public class MoveStockBillQuery {
    @ApiModelProperty("移库单编号 精确匹配")
    private String moveStockBillNo;

    @ApiModelProperty("出库仓库id 精确匹配")
    private Long outWarehouseId;

    @ApiModelProperty("入库仓库id 精确匹配")
    private Long inWarehouseId;

    @ApiModelProperty("状态 精确匹配")
    private Integer status;

}
