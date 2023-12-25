package com.zane.wms.convert;

import org.mapstruct.Mapper;
import com.zane.wms.domain.MoveStockBill;
import com.zane.wms.pojo.dto.MoveStockBillDTO;
import com.zane.wms.pojo.vo.MoveStockBillVO;
import java.util.List;
/**
 * 移库单  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface MoveStockBillConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    MoveStockBillDTO do2dto(MoveStockBill source);

    /**
     * @param source DTO
     * @return DO
     */
    MoveStockBill dto2do(MoveStockBillDTO source);

    List<MoveStockBillVO> dos2vos(List<MoveStockBill> list);
}
