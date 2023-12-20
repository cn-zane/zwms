package com.zane.wms.pojo.dto;

import com.zane.common.core.domain.BaseAudit;
import lombok.Data;
/**
 * 货区 DTO 对象
 *
 * @author zane
 */
@Data
public class AreaDTO extends BaseAudit {
    private Long id;
    private String areaNo;
    private String areaName;
    private Long warehouseId;
    private String remark;
}
