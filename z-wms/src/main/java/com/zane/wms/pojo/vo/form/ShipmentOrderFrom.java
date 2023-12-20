package com.zane.wms.pojo.vo.form;

import com.zane.wms.domain.ShipmentOrder;
import com.zane.wms.pojo.vo.DeliveryVO;
import com.zane.wms.pojo.vo.ItemVO;
import com.zane.wms.pojo.vo.ShipmentOrderDetailVO;
import lombok.Data;

import java.util.List;

@Data
public class ShipmentOrderFrom extends ShipmentOrder {
  // 出库单详情
  private List<ShipmentOrderDetailVO> details;
  // 所有商品
  private List<ItemVO> items;
  // 物流信息
  private List<DeliveryVO> delivery;
}
