package com.zane.wms.pojo.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 库存记录 数据视图对象
 *
 * @author zane
 */
@Data
public class InventoryHistoryVO  {
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
   /** 表单id（出库、入库、移库表id） */
    @Excel(name = "表单id", readConverterExp = "出=库、入库、移库表id")
    private Long formId;
   /** 操作类型 */
    @Excel(name = "操作类型")
    private Integer actionType;
   /** 物料id */
    @Excel(name = "物料id")
    private Long itemId;
   /** 库存变化 */
    @Excel(name = "库存变化")
    private BigDecimal quantity;
   /** 所属仓库 */
    @Excel(name = "所属仓库")
    private Long warehouseId;
   /** 备注 */
    @Excel(name = "备注")
    private String remark;
}
