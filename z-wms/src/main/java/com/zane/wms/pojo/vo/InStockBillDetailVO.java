package com.zane.wms.pojo.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 入库单详情 数据视图对象
 *
 * @author zane
 */
@Data
public class InStockBillDetailVO  {
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
   /** 入库单id */
    @Excel(name = "入库单id")
    private Long inStockBillId;
   /** 物料id */
    @Excel(name = "物料id")
    private Long matId;
   /** 计划数量 */
    @Excel(name = "计划数量")
    private BigDecimal planQuantity;
   /** 实际数量 */
    @Excel(name = "实际数量")
    private BigDecimal realQuantity;
   /** 金额 */
    @Excel(name = "金额")
    private BigDecimal money;
   /** 所属仓库 */
    @Excel(name = "所属仓库")
    private String warehouseId;
   /** 入库状态 */
    @Excel(name = "入库状态")
    private Integer inStockStatus;
   /** 备注 */
    @Excel(name = "备注")
    private String remark;
}
