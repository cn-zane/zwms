package com.zane.wms.convert;

import com.zane.wms.pojo.dto.RackDTO;
import com.zane.wms.pojo.vo.RackVO;
import org.mapstruct.Mapper;
import com.zane.wms.domain.Rack;

import java.util.List;
/**
 * 货架  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface RackConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    RackDTO do2dto(Rack source);

    /**
     * @param source DTO
     * @return DO
     */
    Rack dto2do(RackDTO source);

    List<RackVO> dos2vos(List<Rack> list);
}
