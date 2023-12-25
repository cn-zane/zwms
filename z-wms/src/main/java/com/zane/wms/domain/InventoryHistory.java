package com.zane.wms.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 库存记录对象 wms_inventory_history
 *
 * @author zane
 */
@ApiModel(description="库存记录对象")
@Data
@TableName("wms_inventory_history")
public class InventoryHistory {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改人")
    private String updateBy;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("表单id（出库、入库、移库表id）")
    @Excel(name = "表单id", readConverterExp = "出=库、入库、移库表id")
    private Long formId;

    @ApiModelProperty("操作类型")
    @Excel(name = "操作类型")
    private Integer actionType;

    @ApiModelProperty("物料id")
    @Excel(name = "物料id")
    private Long itemId;

    @ApiModelProperty("库存变化")
    @Excel(name = "库存变化")
    private BigDecimal quantity;

    @ApiModelProperty("所属仓库")
    @Excel(name = "所属仓库")
    private Long warehouseId;

    @ApiModelProperty("删除标识")
    private Integer delFlag;

    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String remark;

}
