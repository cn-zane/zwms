package com.zane.wms.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 仓库 DTO 对象
 *
 * @author zane
 */
@Data
public class WarehouseDTO {
    private Long id;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private String warehouseNo;
    private String warehouseName;
    private String remark;
}
