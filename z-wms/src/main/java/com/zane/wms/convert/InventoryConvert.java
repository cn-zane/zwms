package com.zane.wms.convert;

import com.zane.wms.domain.InventoryHistory;
import com.zane.wms.pojo.dto.InventoryDTO;
import com.zane.wms.pojo.vo.InventoryVO;
import org.mapstruct.Mapper;
import com.zane.wms.domain.Inventory;

import java.util.List;
/**
 * 库存  DO <=> DTO <=> VO / BO / Query
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

    Inventory inventoryHistory2invertory(InventoryHistory it);
}
