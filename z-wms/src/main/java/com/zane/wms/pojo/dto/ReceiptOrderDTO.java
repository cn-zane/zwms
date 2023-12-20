package com.zane.wms.pojo.dto;

import com.zane.common.core.domain.BaseAudit;
import lombok.Data;
/**
 * 入库单 DTO 对象
 *
 * @author zane
 */
@Data
public class ReceiptOrderDTO extends BaseAudit {
    private Long id;
    private String receiptOrderNo;
    private Integer receiptOrderType;
    private Long supplierId;
    private String orderNo;
    private Integer receiptOrderStatus;
    private String remark;
}
