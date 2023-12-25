package com.zane.wms.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 出库单对象 wms_out_stock_bill
 *
 * @author zane
 */
@ApiModel(description="出库单对象")
@Data
@TableName("wms_out_stock_bill")
public class OutStockBill {
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

    @ApiModelProperty("出库单号")
    @Excel(name = "出库单号")
    private String outStockBillNo;

    @ApiModelProperty("出库类型")
    @Excel(name = "出库类型")
    private Integer outStockType;

    @ApiModelProperty("出库订单号")
    @Excel(name = "出库订单号")
    private String orderNo;

    @ApiModelProperty("客户id")
    @Excel(name = "客户id")
    private Long customerId;

    @ApiModelProperty("订单金额")
    @Excel(name = "订单金额")
    private BigDecimal receivableAmount;

    @ApiModelProperty("出库状态")
    @Excel(name = "出库状态")
    private Integer outStockStatus;

    @ApiModelProperty("审核状态")
    @Excel(name = "审核状态")
    private Integer checkStatus;

    @ApiModelProperty("审核人")
    @Excel(name = "审核人")
    private Long checkUserId;

    @ApiModelProperty("审核时间")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkTime;

    @ApiModelProperty("删除标识")
    private Integer delFlag;

    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String remark;

}
