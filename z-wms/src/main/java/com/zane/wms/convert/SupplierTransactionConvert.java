package com.zane.wms.convert;

import com.zane.wms.pojo.dto.SupplierTransactionDTO;
import com.zane.wms.pojo.vo.SupplierTransactionVO;
import org.mapstruct.Mapper;
import com.zane.wms.domain.SupplierTransaction;

import java.util.List;
/**
 * 供应商账户流水  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface SupplierTransactionConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    SupplierTransactionDTO do2dto(SupplierTransaction source);

    /**
     * @param source DTO
     * @return DO
     */
    SupplierTransaction dto2do(SupplierTransactionDTO source);

    List<SupplierTransactionVO> dos2vos(List<SupplierTransaction> list);
}
