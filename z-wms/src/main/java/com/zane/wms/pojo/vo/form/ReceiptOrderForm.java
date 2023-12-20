package com.zane.wms.pojo.vo.form;

import com.zane.wms.domain.ReceiptOrder;
import com.zane.wms.pojo.vo.ItemVO;
import com.zane.wms.pojo.vo.ReceiptOrderDetailVO;
import lombok.Data;

import java.util.List;

@Data
public class ReceiptOrderForm extends ReceiptOrder {
    // 入库单详情
    private List<ReceiptOrderDetailVO> details;
    // 所有商品
    private List<ItemVO> items;
}
