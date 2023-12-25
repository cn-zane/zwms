package com.zane.wms.pojo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
/**
 * 入库单详情 DTO 对象
 *
 * @author zane
 */
@Data
public class InStockBillDetailDTO {
    private Long id;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private Long inStockBillId;
    private Long matId;
    private BigDecimal planQuantity;
    private BigDecimal realQuantity;
    private BigDecimal money;
    private String warehouseId;
    private Integer inStockStatus;
    private String remark;
}
