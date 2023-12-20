package com.zane.wms.convert;

import com.zane.wms.pojo.vo.form.InventoryMovementFrom;
import com.zane.wms.pojo.dto.InventoryMovementDTO;
import com.zane.wms.pojo.vo.InventoryMovementVO;
import org.mapstruct.Mapper;
import com.zane.wms.domain.InventoryMovement;

import java.util.List;

/**
 * 库存移动  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface InventoryMovementConvert {

  /**
   * @param source DO
   * @return DTO
   */
  InventoryMovementDTO do2dto(InventoryMovement source);

  /**
   * @param source DTO
   * @return DO
   */
  InventoryMovement dto2do(InventoryMovementDTO source);

  List<InventoryMovementVO> dos2vos(List<InventoryMovement> list);

  InventoryMovementFrom do2form(InventoryMovement order);
}
