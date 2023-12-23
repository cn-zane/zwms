package com.zane.wms.domain;

import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 仓库对象 wms_base_warehouse
 *
 * @author zane
 */
@ApiModel(description="仓库对象")
@Data
@TableName("wms_base_warehouse")
public class Warehouse {
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

    @ApiModelProperty("仓库编号")
    @Excel(name = "仓库编号")
    private String warehouseNo;

    @ApiModelProperty("仓库名称")
    @Excel(name = "仓库名称")
    private String warehouseName;

    @ApiModelProperty("删除标识")
    private Integer delFlag;

    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String remark;

}
