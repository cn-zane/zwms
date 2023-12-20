package com.zane.wms.convert;

import com.zane.wms.pojo.vo.form.ReceiptOrderForm;
import com.zane.wms.pojo.dto.ReceiptOrderDTO;
import com.zane.wms.pojo.vo.ReceiptOrderVO;
import org.mapstruct.Mapper;
import com.zane.wms.domain.ReceiptOrder;

import java.util.List;
/**
 * 入库单  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface ReceiptOrderConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    ReceiptOrderDTO do2dto(ReceiptOrder source);

    /**
     * @param source DTO
     * @return DO
     */
    ReceiptOrder dto2do(ReceiptOrderDTO source);

    List<ReceiptOrderVO> dos2vos(List<ReceiptOrder> list);

    ReceiptOrderForm do2form(ReceiptOrder bean);
}
