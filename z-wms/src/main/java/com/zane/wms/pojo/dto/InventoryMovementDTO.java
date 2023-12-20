package com.zane.wms.pojo.dto;

import java.time.LocalDateTime;
import com.zane.common.core.domain.BaseAudit;
import lombok.Data;
/**
 * 库存移动 DTO 对象
 *
 * @author zane
 */
@Data
public class InventoryMovementDTO extends BaseAudit {
    private Long id;
    private String inventoryMovementNo;
    private Long sourceRackId;
    private Long targetRackId;
    private Integer status;
    private Integer checkStatus;
    private Long checkUserId;
    private LocalDateTime checkTime;
    private String remark;
}
