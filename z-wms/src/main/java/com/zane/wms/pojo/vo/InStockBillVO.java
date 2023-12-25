package com.zane.wms.pojo.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 入库单 数据视图对象
 *
 * @author zane
 */
@Data
public class InStockBillVO  {
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
   /** 入库单号 */
    @Excel(name = "入库单号")
    private String inStockBillNo;
   /** 入库类型 */
    @Excel(name = "入库类型")
    private Integer inStockType;
   /** 供应商 */
    @Excel(name = "供应商")
    private Long supplierId;
   /** 订单号 */
    @Excel(name = "订单号")
    private String orderNo;
   /** 订单金额 */
    @Excel(name = "订单金额")
    private BigDecimal payableAmount;
   /** 入库状态 */
    @Excel(name = "入库状态")
    private Integer inStockStatus;
   /** 备注 */
    @Excel(name = "备注")
    private String remark;
}
