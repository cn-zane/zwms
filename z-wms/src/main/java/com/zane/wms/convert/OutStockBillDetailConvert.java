package com.zane.wms.convert;

import org.mapstruct.Mapper;
import com.zane.wms.domain.OutStockBillDetail;
import com.zane.wms.pojo.dto.OutStockBillDetailDTO;
import com.zane.wms.pojo.vo.OutStockBillDetailVO;
import java.util.List;
/**
 * 出库单详情  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface OutStockBillDetailConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    OutStockBillDetailDTO do2dto(OutStockBillDetail source);

    /**
     * @param source DTO
     * @return DO
     */
    OutStockBillDetail dto2do(OutStockBillDetailDTO source);

    List<OutStockBillDetailVO> dos2vos(List<OutStockBillDetail> list);
}
