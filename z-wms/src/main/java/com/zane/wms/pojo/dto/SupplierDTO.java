package com.zane.wms.pojo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
/**
 * 供应商 DTO 对象
 *
 * @author zane
 */
@Data
public class SupplierDTO {
    private Long id;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private String supplierNo;
    private String supplierName;
    private String bankName;
    private String bankAccount;
    private BigDecimal accountPayable;
    private String address;
    private String mobile;
    private String tel;
    private String contact;
    private String level;
    private String email;
    private String remark;
}
