package com.zane.wms.pojo.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 移库单详情 数据视图对象
 *
 * @author zane
 */
@Data
public class MoveStockBillDetailVO  {
   /** ID */
    private Long id;
   /** 创建人 */
    private String createBy;
   /** 创建时间 */
    private LocalDateTime createTime;
   /** 修改人 */
    private String updateBy;
   /** 修改时间 */
    private LocalDateTime updateTime;
   /** 移库单id */
    @Excel(name = "移库单id")
    private Long moveStockId;
   /** 物料id */
    @Excel(name = "物料id")
    private Long itemId;
   /** 计划数量 */
    @Excel(name = "计划数量")
    private BigDecimal planQuantity;
   /** 实际数量 */
    @Excel(name = "实际数量")
    private BigDecimal realQuantity;
   /** 出库仓库id */
    @Excel(name = "出库仓库id")
    private Long outWarehouseId;
   /** 入库仓库id */
    @Excel(name = "入库仓库id")
    private Long inWarehouseId;
   /** 移库状态 */
    @Excel(name = "移库状态")
    private Integer moveStatus;
   /** 备注 */
    @Excel(name = "备注")
    private String remark;
}
