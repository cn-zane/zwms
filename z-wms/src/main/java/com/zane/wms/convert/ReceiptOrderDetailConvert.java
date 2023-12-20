package com.zane.wms.convert;

import com.zane.wms.domain.InventoryHistory;
import com.zane.wms.domain.ReceiptOrderDetail;
import com.zane.wms.pojo.dto.ReceiptOrderDetailDTO;
import com.zane.wms.pojo.vo.ReceiptOrderDetailVO;
import org.apache.commons.lang3.SerializationUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 入库单详情  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface ReceiptOrderDetailConvert {

    /**
     * @param source DO
     * @return DTO
     */
    ReceiptOrderDetailDTO do2dto(ReceiptOrderDetail source);

    /**
     * @param source DTO
     * @return DO
     */
    ReceiptOrderDetail dto2do(ReceiptOrderDetailDTO source);

    /**
     * @param source DO
     * @return VO
     */
    ReceiptOrderDetailVO toVo(ReceiptOrderDetail source);

    List<ReceiptOrderDetailVO> dos2vos(List<ReceiptOrderDetail> list);

    List<ReceiptOrderDetail> vos2dos(List<ReceiptOrderDetailVO> details);

    @Mapping(target = "quantity", source = "realQuantity")
    InventoryHistory do2InventoryHistory(ReceiptOrderDetailVO it);

    default Collection<ReceiptOrderDetailVO> copyList(Collection<ReceiptOrderDetailVO> original) {
        List<ReceiptOrderDetailVO> deepCopy = new ArrayList<>();

        for (ReceiptOrderDetailVO element : original) {
            byte[] serializedObject = SerializationUtils.serialize(element);
            ReceiptOrderDetailVO clonedElement = SerializationUtils.deserialize(serializedObject);
            deepCopy.add(clonedElement);
        }

        return deepCopy;
    }
}
