package com.zane.wms.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 承运商 DTO 对象
 *
 * @author zane
 */
@Data
public class CarrierDTO {
    private Long id;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
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
