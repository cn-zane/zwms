package com.zane.wms.pojo.query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 物料 查询 对象
 *
 * @author zane
 */
@ApiModel(description="物料 查询 对象")
@Data
public class MatQuery {
    @ApiModelProperty("物料编号 精确匹配")
    private String matNo;

    @ApiModelProperty("物料名称 精确匹配")
    private String matNameLike;

    @ApiModelProperty("规格 精确匹配")
    private String specification;

    @ApiModelProperty("物料分类 精确匹配")
    private String matType;

    @ApiModelProperty("单位类别 精确匹配")
    private String unit;

    @ApiModelProperty("单价 精确匹配")
    private BigDecimal unitPrice;

    @ApiModelProperty("所属仓库 精确匹配")
    private String warehouseId;

    @ApiModelProperty("安全库存 精确匹配")
    private BigDecimal quantity;

    @ApiModelProperty("生产日期 精确匹配")
    private LocalDateTime productionDate;

    @ApiModelProperty("有效期 精确匹配")
    private LocalDateTime expiryDate;

    @ApiModelProperty("批次 精确匹配")
    private String batch;

}
