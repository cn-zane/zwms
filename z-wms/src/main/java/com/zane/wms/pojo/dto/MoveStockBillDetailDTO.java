package com.zane.wms.pojo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
/**
 * 移库单详情 DTO 对象
 *
 * @author zane
 */
@Data
public class MoveStockBillDetailDTO {
    private Long id;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private Long moveStockId;
    private Long itemId;
    private BigDecimal planQuantity;
    private BigDecimal realQuantity;
    private Long outWarehouseId;
    private Long inWarehouseId;
    private Integer moveStatus;
    private String remark;
}
