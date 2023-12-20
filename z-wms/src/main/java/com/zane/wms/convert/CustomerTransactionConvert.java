package com.zane.wms.convert;

import com.zane.wms.pojo.dto.CustomerTransactionDTO;
import com.zane.wms.pojo.vo.CustomerTransactionVO;
import org.mapstruct.Mapper;
import com.zane.wms.domain.CustomerTransaction;

import java.util.List;
/**
 * 客户账户流水  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface CustomerTransactionConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    CustomerTransactionDTO do2dto(CustomerTransaction source);

    /**
     * @param source DTO
     * @return DO
     */
    CustomerTransaction dto2do(CustomerTransactionDTO source);

    List<CustomerTransactionVO> dos2vos(List<CustomerTransaction> list);
}
