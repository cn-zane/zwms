package com.zane.wms.pojo.query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 出库单 查询 对象
 *
 * @author zane
 */
@ApiModel(description="出库单 查询 对象")
@Data
public class OutStockBillQuery {
    @ApiModelProperty("出库单号 精确匹配")
    private String outStockBillNo;

    @ApiModelProperty("出库类型 精确匹配")
    private Integer outStockType;

    @ApiModelProperty("出库订单号 精确匹配")
    private String orderNo;

    @ApiModelProperty("出库状态 精确匹配")
    private Integer outStockStatus;

}
