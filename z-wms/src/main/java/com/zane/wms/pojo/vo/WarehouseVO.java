package com.zane.wms.pojo.vo;

import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 仓库 数据视图对象
 *
 * @author zane
 */
@Data
public class WarehouseVO  {
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
   /** 仓库编号 */
    @Excel(name = "仓库编号")
    private String warehouseNo;
   /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String warehouseName;
   /** 备注 */
    @Excel(name = "备注")
    private String remark;
}
