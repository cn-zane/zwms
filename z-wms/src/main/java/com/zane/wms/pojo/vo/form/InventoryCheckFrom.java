package com.zane.wms.pojo.vo.form;

import com.zane.wms.domain.InventoryCheck;
import com.zane.wms.pojo.vo.InventoryCheckDetailVO;
import com.zane.wms.pojo.vo.ItemVO;
import lombok.Data;

import java.util.List;

/**
 * 盘库单据 数据视图对象
 *
 * @author zhangcheng
 */
@Data
public class InventoryCheckFrom extends InventoryCheck {
    // 盘库单据详情
    private List<InventoryCheckDetailVO> details;
    // 所有商品
    private List<ItemVO> items;
}
