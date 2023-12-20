package com.zane.wms.pojo.dto;

import com.zane.common.core.domain.BaseAudit;
import lombok.Data;
/**
 * 货架 DTO 对象
 *
 * @author zane
 */
@Data
public class RackDTO extends BaseAudit {
    private Long id;
    private String rackNo;
    private String rackName;
    private Long areaId;
    private Long warehouseId;
    private String remark;
}
