package com.zane.wms.pojo.dto;

import java.math.BigDecimal;
import com.zane.common.core.domain.BaseAudit;
import lombok.Data;
/**
 * 库存盘点单据详情 DTO 对象
 *
 * @author zane
 */
@Data
public class InventoryCheckDetailDTO extends BaseAudit {
    private Long id;
    private Long inventoryCheckId;
    private Long itemId;
    private BigDecimal quantity;
    private BigDecimal checkQuantity;
    private Long warehouseId;
    private Long areaId;
    private Long rackId;
    private String remark;
}
