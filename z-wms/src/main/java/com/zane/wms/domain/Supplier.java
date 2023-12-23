package com.zane.wms.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 供应商对象 wms_base_supplier
 *
 * @author zane
 */
@ApiModel(description="供应商对象")
@Data
@TableName("wms_base_supplier")
public class Supplier {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改人")
    private String updateBy;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("供应商编号")
    @Excel(name = "供应商编号")
    private String supplierNo;

    @ApiModelProperty("供应商名称")
    @Excel(name = "供应商名称")
    private String supplierName;

    @ApiModelProperty("开户行")
    @Excel(name = "开户行")
    private String bankName;

    @ApiModelProperty("银行账户")
    @Excel(name = "银行账户")
    private String bankAccount;

    @ApiModelProperty("应付款")
    @Excel(name = "应付款")
    private BigDecimal accountPayable;

    @ApiModelProperty("地址")
    @Excel(name = "地址")
    private String address;

    @ApiModelProperty("手机号")
    @Excel(name = "手机号")
    private String mobile;

    @ApiModelProperty("座机号")
    @Excel(name = "座机号")
    private String tel;

    @ApiModelProperty("联系人")
    @Excel(name = "联系人")
    private String contact;

    @ApiModelProperty("级别")
    @Excel(name = "级别")
    private String level;

    @ApiModelProperty("Email")
    @Excel(name = "Email")
    private String email;

    @ApiModelProperty("删除标识")
    private Integer delFlag;

    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String remark;

}
