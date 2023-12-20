package com.zane.wms.pojo.dto;

import java.time.LocalDateTime;
import com.zane.common.core.domain.BaseAudit;
import lombok.Data;
/**
 * 出库单 DTO 对象
 *
 * @author zane
 */
@Data
public class ShipmentOrderDTO extends BaseAudit {
    private Long id;
    private String shipmentOrderNo;
    private Integer shipmentOrderType;
    private String orderNo;
    private Long customerId;
    private Integer shipmentOrderStatus;
    private Integer checkStatus;
    private Long checkUserId;
    private LocalDateTime checkTime;
    private String remark;
}
