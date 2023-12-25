package com.zane.wms.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 移库单 DTO 对象
 *
 * @author zane
 */
@Data
public class MoveStockBillDTO {
    private Long id;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private String moveStockBillNo;
    private Long outWarehouseId;
    private Long inWarehouseId;
    private Integer status;
    private Integer checkStatus;
    private Long checkUserId;
    private LocalDateTime checkTime;
    private String remark;
}
