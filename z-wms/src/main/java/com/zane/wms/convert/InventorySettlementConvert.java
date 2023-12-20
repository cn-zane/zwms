package com.zane.wms.convert;

import com.zane.wms.domain.InventorySettlement;
import com.zane.wms.pojo.dto.InventorySettlementDTO;
import com.zane.wms.pojo.vo.InventorySettlementVO;
import com.zane.wms.pojo.vo.form.InventorySettlementFrom;
import org.mapstruct.Mapper;

import java.util.List;
/**
 * 库存结算单  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface InventorySettlementConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    InventorySettlementDTO do2dto(InventorySettlement source);

    /**
     * @param source DTO
     * @return DO
     */
    InventorySettlement dto2do(InventorySettlementDTO source);

    List<InventorySettlementVO> dos2vos(List<InventorySettlement> list);

    InventorySettlementFrom do2form(InventorySettlement inventorySettlement);
}
