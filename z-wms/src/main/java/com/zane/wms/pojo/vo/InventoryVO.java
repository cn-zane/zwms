package com.zane.wms.pojo.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 库存表 数据视图对象
 *
 * @author zane
 */
@Data
public class InventoryVO  {
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
   /** 物料id */
    @Excel(name = "物料id")
    private Long matId;
   /** 物料id */
    @Excel(name = "物料名称")
    private String matName;
   /** 库存数量 */
    @Excel(name = "库存数量")
    private BigDecimal quantity;
   /** 所属仓库 */
    @Excel(name = "所属仓库")
    private Long warehouseId;
   /** 备注 */
    @Excel(name = "备注")
    private String remark;
}
