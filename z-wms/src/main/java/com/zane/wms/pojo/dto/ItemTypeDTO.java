package com.zane.wms.pojo.dto;

import com.zane.common.core.domain.BaseAudit;
import lombok.Data;
/**
 * 物料类型表 DTO 对象
 *
 * @author zane
 */
@Data
public class ItemTypeDTO extends BaseAudit {
    private Long itemTypeId;
    private Long parentId;
    private String ancestors;
    private String typeName;
    private Integer orderNum;
    private String status;
}
