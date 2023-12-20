package com.zane.wms.pojo.dto;

import com.zane.common.core.domain.BaseAudit;
import lombok.Data;
/**
 * 库存结算单 DTO 对象
 *
 * @author zane
 */
@Data
public class InventorySettlementDTO extends BaseAudit {
    private Long id;
    private Integer inventorySettlementStatus;
    private Integer settlementType;
    private String remark;
    private String inventorySettlementNo;
}
