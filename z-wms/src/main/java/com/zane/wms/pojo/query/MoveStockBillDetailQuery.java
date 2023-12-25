package com.zane.wms.pojo.query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 移库单详情 查询 对象
 *
 * @author zane
 */
@ApiModel(description="移库单详情 查询 对象")
@Data
public class MoveStockBillDetailQuery {
    @ApiModelProperty("移库单id 精确匹配")
    private Long moveStockId;

    @ApiModelProperty("物料id 精确匹配")
    private Long itemId;

    @ApiModelProperty("出库仓库id 精确匹配")
    private Long outWarehouseId;

    @ApiModelProperty("入库仓库id 精确匹配")
    private Long inWarehouseId;

    @ApiModelProperty("移库状态 精确匹配")
    private Integer moveStatus;

}
