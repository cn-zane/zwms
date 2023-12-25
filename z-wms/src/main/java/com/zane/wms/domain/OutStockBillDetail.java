package com.zane.wms.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 出库单详情对象 wms_out_stock_bill_detail
 *
 * @author zane
 */
@ApiModel(description="出库单详情对象")
@Data
@TableName("wms_out_stock_bill_detail")
public class OutStockBillDetail {
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

    @ApiModelProperty("出库单id")
    @Excel(name = "出库单id")
    private Long outStockBillId;

    @ApiModelProperty("物料id")
    @Excel(name = "物料id")
    private Long itemId;

    @ApiModelProperty("计划数量")
    @Excel(name = "计划数量")
    private BigDecimal planQuantity;

    @ApiModelProperty("实际数量")
    @Excel(name = "实际数量")
    private BigDecimal realQuantity;

    @ApiModelProperty("金额")
    @Excel(name = "金额")
    private BigDecimal money;

    @ApiModelProperty("所属仓库")
    @Excel(name = "所属仓库")
    private Long warehouseId;

    @ApiModelProperty("出库状态")
    @Excel(name = "出库状态")
    private Integer outStockStatus;

    @ApiModelProperty("删除标识")
    private Integer delFlag;

    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String remark;

}
