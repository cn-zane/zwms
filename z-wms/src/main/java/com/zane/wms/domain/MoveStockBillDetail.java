package com.zane.wms.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 移库单详情对象 wms_move_stock_bill_detail
 *
 * @author zane
 */
@ApiModel(description="移库单详情对象")
@Data
@TableName("wms_move_stock_bill_detail")
public class MoveStockBillDetail {
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

    @ApiModelProperty("移库单id")
    @Excel(name = "移库单id")
    private Long moveStockId;

    @ApiModelProperty("物料id")
    @Excel(name = "物料id")
    private Long itemId;

    @ApiModelProperty("计划数量")
    @Excel(name = "计划数量")
    private BigDecimal planQuantity;

    @ApiModelProperty("实际数量")
    @Excel(name = "实际数量")
    private BigDecimal realQuantity;

    @ApiModelProperty("出库仓库id")
    @Excel(name = "出库仓库id")
    private Long outWarehouseId;

    @ApiModelProperty("入库仓库id")
    @Excel(name = "入库仓库id")
    private Long inWarehouseId;

    @ApiModelProperty("移库状态")
    @Excel(name = "移库状态")
    private Integer moveStatus;

    @ApiModelProperty("删除标识")
    private Integer delFlag;

    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String remark;

}
