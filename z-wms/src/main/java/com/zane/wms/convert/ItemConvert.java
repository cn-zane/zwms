package com.zane.wms.convert;

import com.zane.wms.pojo.dto.ItemDTO;
import com.zane.wms.pojo.vo.ItemVO;
import org.mapstruct.Mapper;
import com.zane.wms.domain.Item;

import java.util.List;
/**
 * 物料  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface ItemConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    ItemDTO do2dto(Item source);

    /**
     * @param source DTO
     * @return DO
     */
    Item dto2do(ItemDTO source);

    /**
     * @param source DO
     * @return VO
     */
    ItemVO toVo(Item source);

    List<ItemVO> dos2vos(List<Item> list);
}
