package com.zane.wms.pojo.query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 入库单详情 查询 对象
 *
 * @author zane
 */
@ApiModel(description="入库单详情 查询 对象")
@Data
public class InStockBillDetailQuery {
    @ApiModelProperty("入库单id 精确匹配")
    private Long inStockBillId;

    @ApiModelProperty("物料id 精确匹配")
    private Long matId;

    @ApiModelProperty("计划数量 精确匹配")
    private BigDecimal planQuantity;

    @ApiModelProperty("实际数量 精确匹配")
    private BigDecimal realQuantity;

    @ApiModelProperty("金额 精确匹配")
    private BigDecimal money;

    @ApiModelProperty("所属仓库 精确匹配")
    private String warehouseId;

    @ApiModelProperty("入库状态 精确匹配")
    private Integer inStockStatus;

}
