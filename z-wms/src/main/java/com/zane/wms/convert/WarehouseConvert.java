package com.zane.wms.convert;

import com.zane.wms.pojo.dto.WarehouseDTO;
import com.zane.wms.pojo.vo.WarehouseVO;
import org.mapstruct.Mapper;
import com.zane.wms.domain.Warehouse;

import java.util.List;
/**
 * 仓库  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface WarehouseConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    WarehouseDTO do2dto(Warehouse source);

    /**
     * @param source DTO
     * @return DO
     */
    Warehouse dto2do(WarehouseDTO source);

    List<WarehouseVO> dos2vos(List<Warehouse> list);
}
