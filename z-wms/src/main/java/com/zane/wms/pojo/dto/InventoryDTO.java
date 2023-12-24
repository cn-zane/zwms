package com.zane.wms.pojo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
/**
 * 库存表 DTO 对象
 *
 * @author zane
 */
@Data
public class InventoryDTO {
    private Long id;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private Long matId;
    private String matName;
    private BigDecimal quantity;
    private Long warehouseId;
    private String remark;
}
