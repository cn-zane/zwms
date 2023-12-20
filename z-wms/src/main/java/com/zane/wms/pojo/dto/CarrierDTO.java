package com.zane.wms.pojo.dto;

import com.zane.common.core.domain.BaseAudit;
import lombok.Data;
/**
 * 承运商 DTO 对象
 *
 * @author zane
 */
@Data
public class CarrierDTO extends BaseAudit {
    private Long id;
    private String carrierNo;
    private String carrierName;
    private String address;
    private String mobile;
    private String tel;
    private String contact;
    private String level;
    private String email;
    private String remark;
}
