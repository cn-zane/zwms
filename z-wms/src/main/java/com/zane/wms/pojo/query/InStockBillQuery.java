package com.zane.wms.pojo.query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 入库单 查询 对象
 *
 * @author zane
 */
@ApiModel(description="入库单 查询 对象")
@Data
public class InStockBillQuery {
    @ApiModelProperty("入库单号 精确匹配")
    private String inStockBillNo;

    @ApiModelProperty("入库类型 精确匹配")
    private Integer inStockType;

    @ApiModelProperty("供应商 精确匹配")
    private Long supplierId;

    @ApiModelProperty("订单号 精确匹配")
    private String orderNo;

    @ApiModelProperty("订单金额 精确匹配")
    private BigDecimal payableAmount;

    @ApiModelProperty("入库状态 精确匹配")
    private Integer inStockStatus;

}
