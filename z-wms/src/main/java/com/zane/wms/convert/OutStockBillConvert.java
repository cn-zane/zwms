package com.zane.wms.convert;

import org.mapstruct.Mapper;
import com.zane.wms.domain.OutStockBill;
import com.zane.wms.pojo.dto.OutStockBillDTO;
import com.zane.wms.pojo.vo.OutStockBillVO;
import java.util.List;
/**
 * 出库单  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface OutStockBillConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    OutStockBillDTO do2dto(OutStockBill source);

    /**
     * @param source DTO
     * @return DO
     */
    OutStockBill dto2do(OutStockBillDTO source);

    List<OutStockBillVO> dos2vos(List<OutStockBill> list);
}
