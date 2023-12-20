package com.zane.wms.pojo.vo.form;

import com.zane.wms.domain.InventoryMovement;
import com.zane.wms.pojo.vo.InventoryMovementDetailVO;
import com.zane.wms.pojo.vo.ItemVO;
import lombok.Data;

import java.util.List;

@Data
public class InventoryMovementFrom extends InventoryMovement {
  // 详情
  private List<InventoryMovementDetailVO> details;
  // 所有商品
  private List<ItemVO> items;
}
