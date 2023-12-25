package com.zane.wms.pojo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
/**
 * 出库单详情 DTO 对象
 *
 * @author zane
 */
@Data
public class OutStockBillDetailDTO {
    private Long id;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private Long outStockBillId;
    private Long itemId;
    private BigDecimal planQuantity;
    private BigDecimal realQuantity;
    private BigDecimal money;
    private Long warehouseId;
    private Integer outStockStatus;
    private String remark;
}
