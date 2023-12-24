package com.zane.wms.pojo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
/**
 * 物料 DTO 对象
 *
 * @author zane
 */
@Data
public class MatDTO {
    private Long id;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private String matNo;
    private String matName;
    private String specification;
    private String matType;
    private String unit;
    private BigDecimal unitPrice;
    private String warehouseId;
    private BigDecimal quantity;
    private LocalDateTime productionDate;
    private LocalDateTime expiryDate;
    private String batch;
    private String remark;
}
