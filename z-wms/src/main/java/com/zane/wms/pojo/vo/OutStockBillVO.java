package com.zane.wms.pojo.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 出库单 数据视图对象
 *
 * @author zane
 */
@Data
public class OutStockBillVO  {
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
   /** 出库单号 */
    @Excel(name = "出库单号")
    private String outStockBillNo;
   /** 出库类型 */
    @Excel(name = "出库类型")
    private Integer outStockType;
   /** 出库订单号 */
    @Excel(name = "出库订单号")
    private String orderNo;
   /** 客户id */
    @Excel(name = "客户id")
    private Long customerId;
   /** 订单金额 */
    @Excel(name = "订单金额")
    private BigDecimal receivableAmount;
   /** 出库状态 */
    @Excel(name = "出库状态")
    private Integer outStockStatus;
   /** 审核状态 */
    @Excel(name = "审核状态")
    private Integer checkStatus;
   /** 审核人 */
    @Excel(name = "审核人")
    private Long checkUserId;
   /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkTime;
   /** 备注 */
    @Excel(name = "备注")
    private String remark;
}
