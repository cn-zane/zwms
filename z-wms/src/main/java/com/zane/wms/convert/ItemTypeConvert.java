package com.zane.wms.convert;

import com.zane.wms.pojo.dto.ItemTypeDTO;
import com.zane.wms.pojo.vo.ItemTypeVO;
import org.mapstruct.Mapper;
import com.zane.wms.domain.ItemType;

import java.util.List;
/**
 * 物料类型表  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface ItemTypeConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    ItemTypeDTO do2dto(ItemType source);

    /**
     * @param source DTO
     * @return DO
     */
    ItemType dto2do(ItemTypeDTO source);

    List<ItemTypeVO> dos2vos(List<ItemType> list);
}
