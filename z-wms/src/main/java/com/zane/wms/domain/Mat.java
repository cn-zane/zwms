package com.zane.wms.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 物料对象 wms_base_mat
 *
 * @author zane
 */
@ApiModel(description="物料对象")
@Data
@TableName("wms_base_mat")
public class Mat {
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

    @ApiModelProperty("物料编号")
    @Excel(name = "物料编号")
    private String matNo;

    @ApiModelProperty("物料名称")
    @Excel(name = "物料名称")
    private String matName;

    @ApiModelProperty("规格")
    @Excel(name = "规格")
    private String specification;

    @ApiModelProperty("物料分类")
    @Excel(name = "物料分类")
    private String matType;

    @ApiModelProperty("单位类别")
    @Excel(name = "单位类别")
    private String unit;

    @ApiModelProperty("单价")
    @Excel(name = "单价")
    private BigDecimal unitPrice;

    @ApiModelProperty("所属仓库")
    @Excel(name = "所属仓库")
    private String warehouseId;

    @ApiModelProperty("安全库存")
    @Excel(name = "安全库存")
    private BigDecimal quantity;

    @ApiModelProperty("生产日期")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime productionDate;

    @ApiModelProperty("有效期")
    @Excel(name = "有效期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expiryDate;

    @ApiModelProperty("批次")
    @Excel(name = "批次")
    private String batch;

    @ApiModelProperty("删除标识")
    private Integer delFlag;

    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String remark;

}
