package com.zane.wms.pojo.vo;

import com.zane.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zane.common.core.domain.BaseAudit;
import lombok.Data;
/**
 * 仓库 数据视图对象
 *
 * @author zane
 */
@Data
public class WarehouseVO extends BaseAudit {
   /** ID */
    private Long id;
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
