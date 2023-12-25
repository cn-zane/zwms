package com.zane.wms.pojo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
/**
 * 库存记录 DTO 对象
 *
 * @author zane
 */
@Data
public class InventoryHistoryDTO {
    private Long id;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private Long formId;
    private Integer actionType;
    private Long itemId;
    private BigDecimal quantity;
    private Long warehouseId;
    private String remark;
}
