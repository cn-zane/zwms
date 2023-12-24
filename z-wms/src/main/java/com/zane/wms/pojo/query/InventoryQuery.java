package com.zane.wms.pojo.query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 库存表 查询 对象
 *
 * @author zane
 */
@ApiModel(description="库存表 查询 对象")
@Data
public class InventoryQuery {
    @ApiModelProperty("物料id 精确匹配")
    private Long matId;

    @ApiModelProperty("库存数量 精确匹配")
    private BigDecimal quantity;

    @ApiModelProperty("所属仓库 精确匹配")
    private Long warehouseId;

}
