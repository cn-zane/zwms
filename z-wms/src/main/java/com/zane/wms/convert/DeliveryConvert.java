package com.zane.wms.convert;

import com.zane.wms.pojo.dto.DeliveryDTO;
import com.zane.wms.pojo.vo.DeliveryVO;
import org.mapstruct.Mapper;
import com.zane.wms.domain.Delivery;

import java.util.List;
/**
 * 发货记录  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface DeliveryConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    DeliveryDTO do2dto(Delivery source);

    /**
     * @param source DTO
     * @return DO
     */
    Delivery dto2do(DeliveryDTO source);

    List<DeliveryVO> dos2vos(List<Delivery> list);
}
