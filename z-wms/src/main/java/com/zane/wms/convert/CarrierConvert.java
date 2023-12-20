package com.zane.wms.convert;

import com.zane.wms.pojo.dto.CarrierDTO;
import com.zane.wms.pojo.vo.CarrierVO;
import org.mapstruct.Mapper;
import com.zane.wms.domain.Carrier;

import java.util.List;
/**
 * 承运商  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface CarrierConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    CarrierDTO do2dto(Carrier source);

    /**
     * @param source DTO
     * @return DO
     */
    Carrier dto2do(CarrierDTO source);

    List<CarrierVO> dos2vos(List<Carrier> list);
}
