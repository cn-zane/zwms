package com.zane.wms.pojo.dto;

import java.time.LocalDateTime;
import com.zane.common.core.domain.BaseAudit;
import lombok.Data;
/**
 * 发货记录 DTO 对象
 *
 * @author zane
 */
@Data
public class DeliveryDTO extends BaseAudit {
    private Long id;
    private Long shipmentOrderId;
    private Long carrierId;
    private LocalDateTime deliveryDate;
    private String trackingNo;
    private String remark;
}
