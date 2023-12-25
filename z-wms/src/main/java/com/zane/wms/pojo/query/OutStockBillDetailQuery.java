package com.zane.wms.pojo.query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 出库单详情 查询 对象
 *
 * @author zane
 */
@ApiModel(description="出库单详情 查询 对象")
@Data
public class OutStockBillDetailQuery {
    @ApiModelProperty("出库单id 精确匹配")
    private Long outStockBillId;

    @ApiModelProperty("物料id 精确匹配")
    private Long itemId;

    @ApiModelProperty("所属仓库 精确匹配")
    private Long warehouseId;

    @ApiModelProperty("出库状态 精确匹配")
    private Integer outStockStatus;

}
