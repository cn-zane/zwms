package com.zane.wms.convert;

import org.mapstruct.Mapper;
import com.zane.wms.domain.InStockBill;
import com.zane.wms.pojo.dto.InStockBillDTO;
import com.zane.wms.pojo.vo.InStockBillVO;
import java.util.List;
/**
 * 入库单  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface InStockBillConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    InStockBillDTO do2dto(InStockBill source);

    /**
     * @param source DTO
     * @return DO
     */
    InStockBill dto2do(InStockBillDTO source);

    List<InStockBillVO> dos2vos(List<InStockBill> list);
}
