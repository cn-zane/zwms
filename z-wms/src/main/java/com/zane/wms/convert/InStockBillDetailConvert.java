package com.zane.wms.convert;

import org.mapstruct.Mapper;
import com.zane.wms.domain.InStockBillDetail;
import com.zane.wms.pojo.dto.InStockBillDetailDTO;
import com.zane.wms.pojo.vo.InStockBillDetailVO;
import java.util.List;
/**
 * 入库单详情  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface InStockBillDetailConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    InStockBillDetailDTO do2dto(InStockBillDetail source);

    /**
     * @param source DTO
     * @return DO
     */
    InStockBillDetail dto2do(InStockBillDetailDTO source);

    List<InStockBillDetailVO> dos2vos(List<InStockBillDetail> list);
}
