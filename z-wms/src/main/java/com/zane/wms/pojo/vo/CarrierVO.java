package com.zane.wms.pojo.vo;

import java.time.LocalDateTime;

import com.zane.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 承运商 数据视图对象
 *
 * @author zane
 */
@Data
public class CarrierVO  {
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
   /** 承运商编号 */
    @Excel(name = "承运商编号")
    private String carrierNo;
   /** 承运商名称 */
    @Excel(name = "承运商名称")
    private String carrierName;
   /** 地址 */
    @Excel(name = "地址")
    private String address;
   /** 手机号 */
    @Excel(name = "手机号")
    private String mobile;
   /** 座机号 */
    @Excel(name = "座机号")
    private String tel;
   /** 联系人 */
    @Excel(name = "联系人")
    private String contact;
   /** 级别 */
    @Excel(name = "级别")
    private String level;
   /** Email */
    @Excel(name = "Email")
    private String email;
   /** 备注 */
    @Excel(name = "备注")
    private String remark;
}
