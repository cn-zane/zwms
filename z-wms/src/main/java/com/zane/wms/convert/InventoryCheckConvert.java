package com.zane.wms.convert;

import com.zane.wms.pojo.vo.form.InventoryCheckFrom;
import com.zane.wms.pojo.dto.InventoryCheckDTO;
import com.zane.wms.pojo.vo.InventoryCheckVO;
import org.mapstruct.Mapper;
import com.zane.wms.domain.InventoryCheck;

import java.util.List;
/**
 * 库存盘点单据  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface InventoryCheckConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    InventoryCheckDTO do2dto(InventoryCheck source);

    /**
     * @param source DTO
     * @return DO
     */
    InventoryCheck dto2do(InventoryCheckDTO source);

    List<InventoryCheckVO> dos2vos(List<InventoryCheck> list);

    InventoryCheckFrom do2form(InventoryCheck inventoryCheck);
}
