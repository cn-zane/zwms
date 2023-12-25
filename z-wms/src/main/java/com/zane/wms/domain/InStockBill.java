package com.zane.wms.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 入库单对象 wms_in_stock_bill
 *
 * @author zane
 */
@ApiModel(description="入库单对象")
@Data
@TableName("wms_in_stock_bill")
public class InStockBill {
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

    @ApiModelProperty("入库单号")
    @Excel(name = "入库单号")
    private String inStockBillNo;

    @ApiModelProperty("入库类型")
    @Excel(name = "入库类型")
    private Integer inStockType;

    @ApiModelProperty("供应商")
    @Excel(name = "供应商")
    private Long supplierId;

    @ApiModelProperty("订单号")
    @Excel(name = "订单号")
    private String orderNo;

    @ApiModelProperty("订单金额")
    @Excel(name = "订单金额")
    private BigDecimal payableAmount;

    @ApiModelProperty("入库状态")
    @Excel(name = "入库状态")
    private Integer inStockStatus;

    @ApiModelProperty("删除标识")
    private Integer delFlag;

    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String remark;

}
