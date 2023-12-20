package com.zane.wms.pojo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.core.domain.BaseAudit;
import lombok.Data;
/**
 * 物料 DTO 对象
 *
 * @author zane
 */
@Data
public class ItemDTO extends BaseAudit {
    private Long id;
    private String itemNo;
    private String itemName;
    private String itemType;
    private String unit;
    private Long rackId;
    private Long areaId;
    private Long warehouseId;
    private BigDecimal quantity;
    private LocalDateTime expiryDate;
    private String remark;
}
