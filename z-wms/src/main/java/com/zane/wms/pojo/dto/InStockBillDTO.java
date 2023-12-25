package com.zane.wms.pojo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
/**
 * 入库单 DTO 对象
 *
 * @author zane
 */
@Data
public class InStockBillDTO {
    private Long id;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private String inStockBillNo;
    private Integer inStockType;
    private Long supplierId;
    private String orderNo;
    private BigDecimal payableAmount;
    private Integer inStockStatus;
    private String remark;
}
