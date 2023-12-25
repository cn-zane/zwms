package com.zane.wms.pojo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
/**
 * 出库单 DTO 对象
 *
 * @author zane
 */
@Data
public class OutStockBillDTO {
    private Long id;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private String outStockBillNo;
    private Integer outStockType;
    private String orderNo;
    private Long customerId;
    private BigDecimal receivableAmount;
    private Integer outStockStatus;
    private Integer checkStatus;
    private Long checkUserId;
    private LocalDateTime checkTime;
    private String remark;
}
