package com.zane.wms.convert;

import com.zane.wms.domain.InventoryHistory;
import com.zane.wms.pojo.dto.InventoryCheckDetailDTO;
import com.zane.wms.pojo.vo.InventoryCheckDetailVO;
import org.mapstruct.Mapper;
import com.zane.wms.domain.InventoryCheckDetail;

import java.util.List;
/**
 * 库存盘点单据详情  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface InventoryCheckDetailConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    InventoryCheckDetailDTO do2dto(InventoryCheckDetail source);

    /**
     * @param source DTO
     * @return DO
     */
    InventoryCheckDetail dto2do(InventoryCheckDetailDTO source);

    List<InventoryCheckDetailVO> dos2vos(List<InventoryCheckDetail> list);

    List<InventoryCheckDetail> vos2dos(List<InventoryCheckDetailVO> details);

    InventoryHistory vo2InventoryHistory(InventoryCheckDetailVO it);
}
