package com.zane.wms.pojo.vo;

import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 移库单 数据视图对象
 *
 * @author zane
 */
@Data
public class MoveStockBillVO  {
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
   /** 移库单编号 */
    @Excel(name = "移库单编号")
    private String moveStockBillNo;
   /** 出库仓库id */
    @Excel(name = "出库仓库id")
    private Long outWarehouseId;
   /** 入库仓库id */
    @Excel(name = "入库仓库id")
    private Long inWarehouseId;
   /** 状态 */
    @Excel(name = "状态")
    private Integer status;
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
