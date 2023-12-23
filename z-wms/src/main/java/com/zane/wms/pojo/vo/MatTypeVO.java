package com.zane.wms.pojo.vo;

import java.time.LocalDateTime;
import com.zane.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 物料类型 数据视图对象
 *
 * @author zane
 */
@Data
public class MatTypeVO  {
   /** 物料类型id */
    private Long matTypeId;
   /** 创建人 */
    private String createBy;
   /** 创建时间 */
    private LocalDateTime createTime;
   /** 修改人 */
    private String updateBy;
   /** 修改时间 */
    private LocalDateTime updateTime;
   /** 物料类型名称 */
    @Excel(name = "物料类型名称")
    private String matTypeName;
   /** 排序 */
    @Excel(name = "排序")
    private Integer sort;
   /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private Integer status;
   /** 备注 */
    @Excel(name = "备注")
    private String remark;
}
