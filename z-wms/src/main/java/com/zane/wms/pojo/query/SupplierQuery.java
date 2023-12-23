package com.zane.wms.pojo.query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 供应商 查询 对象
 *
 * @author zane
 */
@ApiModel(description="供应商 查询 对象")
@Data
public class SupplierQuery {
    @ApiModelProperty("供应商编号 精确匹配")
    private String supplierNo;

    @ApiModelProperty("供应商名称 精确匹配")
    private String supplierNameLike;

    @ApiModelProperty("开户行 精确匹配")
    private String bankNameLike;

    @ApiModelProperty("银行账户 精确匹配")
    private String bankAccount;

    @ApiModelProperty("应付款 精确匹配")
    private BigDecimal accountPayable;

    @ApiModelProperty("地址 精确匹配")
    private String address;

    @ApiModelProperty("手机号 精确匹配")
    private String mobile;

    @ApiModelProperty("座机号 精确匹配")
    private String tel;

    @ApiModelProperty("联系人 精确匹配")
    private String contact;

    @ApiModelProperty("级别 精确匹配")
    private String level;

    @ApiModelProperty("Email 精确匹配")
    private String email;

}
