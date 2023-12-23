package com.zane.wms.pojo.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 客户 数据视图对象
 *
 * @author zane
 */
@Data
public class CustomerVO  {
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
   /** 客户编号 */
    @Excel(name = "客户编号")
    private String customerNo;
   /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;
   /** 开户行 */
    @Excel(name = "开户行")
    private String bankName;
   /** 银行账户 */
    @Excel(name = "银行账户")
    private String bankAccount;
   /** 应收款 */
    @Excel(name = "应收款")
    private BigDecimal accountReceivable;
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
