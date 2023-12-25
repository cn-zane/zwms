package com.zane.wms.convert;

import org.mapstruct.Mapper;
import com.zane.wms.domain.MoveStockBillDetail;
import com.zane.wms.pojo.dto.MoveStockBillDetailDTO;
import com.zane.wms.pojo.vo.MoveStockBillDetailVO;
import java.util.List;
/**
 * 移库单详情  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface MoveStockBillDetailConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    MoveStockBillDetailDTO do2dto(MoveStockBillDetail source);

    /**
     * @param source DTO
     * @return DO
     */
    MoveStockBillDetail dto2do(MoveStockBillDetailDTO source);

    List<MoveStockBillDetailVO> dos2vos(List<MoveStockBillDetail> list);
}
