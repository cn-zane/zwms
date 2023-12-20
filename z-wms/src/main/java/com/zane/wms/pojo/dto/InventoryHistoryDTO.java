package com.zane.wms.pojo.dto;

import java.math.BigDecimal;
import com.zane.common.core.domain.BaseAudit;
import lombok.Data;
/**
 * 库存记录 DTO 对象
 *
 * @author zane
 */
@Data
public class InventoryHistoryDTO extends BaseAudit {
    private Long id;
    private Long formId;
    private Integer formType;
    private Long itemId;
    private Long rackId;
    private Long warehouseId;
    private Long areaId;
    private BigDecimal quantity;
    private String remark;
}
