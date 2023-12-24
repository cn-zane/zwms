package com.zane.wms.convert;

import org.mapstruct.Mapper;
import com.zane.wms.domain.Inventory;
import com.zane.wms.pojo.dto.InventoryDTO;
import com.zane.wms.pojo.vo.InventoryVO;
import java.util.List;
/**
 * 库存表  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface InventoryConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    InventoryDTO do2dto(Inventory source);

    /**
     * @param source DTO
     * @return DO
     */
    Inventory dto2do(InventoryDTO source);

    List<InventoryVO> dos2vos(List<Inventory> list);
}
