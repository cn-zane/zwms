package com.zane.wms.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 承运商 查询 对象
 *
 * @author zane
 */
@ApiModel(description="承运商 查询 对象")
@Data
public class CarrierQuery {
    @ApiModelProperty("承运商编号 精确匹配")
    private String carrierNo;

    @ApiModelProperty("承运商名称 精确匹配")
    private String carrierNameLike;

    @ApiModelProperty("地址 精确匹配")
    private String address;

    @ApiModelProperty("手机号 精确匹配")
    private String mobile;

    @ApiModelProperty("座机号 精确匹配")
    private String tel;

    @ApiModelProperty("联系人 精确匹配")
    private String contact;

    @ApiModelProperty("级别 精确匹配")
    private String level;

    @ApiModelProperty("Email 精确匹配")
    private String email;

}
