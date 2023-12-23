package com.zane.wms.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 物料类型 DTO 对象
 *
 * @author zane
 */
@Data
public class MatTypeDTO {
    private Long matTypeId;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private String matTypeName;
    private Integer sort;
    private Integer status;
    private String remark;
}
