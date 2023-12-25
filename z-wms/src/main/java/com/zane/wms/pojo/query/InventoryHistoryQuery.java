package com.zane.wms.pojo.query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 库存记录 查询 对象
 *
 * @author zane
 */
@ApiModel(description="库存记录 查询 对象")
@Data
public class InventoryHistoryQuery {
    @ApiModelProperty("表单id（出库、入库、移库表id） 精确匹配")
    private Long formId;

    @ApiModelProperty("操作类型 精确匹配")
    private Integer actionType;

    @ApiModelProperty("物料id 精确匹配")
    private Long itemId;

    @ApiModelProperty("库存变化 精确匹配")
    private BigDecimal quantity;

    @ApiModelProperty("所属仓库 精确匹配")
    private Long warehouseId;

}
