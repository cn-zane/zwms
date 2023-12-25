package com.zane.wms.domain;

import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 移库单对象 wms_move_stock_bill
 *
 * @author zane
 */
@ApiModel(description="移库单对象")
@Data
@TableName("wms_move_stock_bill")
public class MoveStockBill {
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

    @ApiModelProperty("移库单编号")
    @Excel(name = "移库单编号")
    private String moveStockBillNo;

    @ApiModelProperty("出库仓库id")
    @Excel(name = "出库仓库id")
    private Long outWarehouseId;

    @ApiModelProperty("入库仓库id")
    @Excel(name = "入库仓库id")
    private Long inWarehouseId;

    @ApiModelProperty("状态")
    @Excel(name = "状态")
    private Integer status;

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
