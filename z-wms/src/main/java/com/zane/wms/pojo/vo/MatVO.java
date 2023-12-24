package com.zane.wms.pojo.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 物料 数据视图对象
 *
 * @author zane
 */
@Data
public class MatVO  {
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
   /** 物料编号 */
    @Excel(name = "物料编号")
    private String matNo;
   /** 物料名称 */
    @Excel(name = "物料名称")
    private String matName;
   /** 规格 */
    @Excel(name = "规格")
    private String specification;
   /** 物料分类 */
    @Excel(name = "物料分类")
    private String matType;
   /** 单位类别 */
    @Excel(name = "单位类别")
    private String unit;
   /** 单价 */
    @Excel(name = "单价")
    private BigDecimal unitPrice;
   /** 所属仓库 */
    @Excel(name = "所属仓库")
    private String warehouseId;
   /** 安全库存 */
    @Excel(name = "安全库存")
    private BigDecimal quantity;
   /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime productionDate;
   /** 有效期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "有效期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expiryDate;
   /** 批次 */
    @Excel(name = "批次")
    private String batch;
   /** 备注 */
    @Excel(name = "备注")
    private String remark;
}
