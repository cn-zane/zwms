package com.zane.wms.convert;

import com.zane.wms.pojo.dto.AreaDTO;
import com.zane.wms.pojo.vo.AreaVO;
import org.mapstruct.Mapper;
import com.zane.wms.domain.Area;

import java.util.List;
/**
 * 货区  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface AreaConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    AreaDTO do2dto(Area source);

    /**
     * @param source DTO
     * @return DO
     */
    Area dto2do(AreaDTO source);

    List<AreaVO> dos2vos(List<Area> list);
}
