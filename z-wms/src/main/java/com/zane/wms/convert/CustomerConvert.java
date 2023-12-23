package com.zane.wms.convert;

import org.mapstruct.Mapper;
import com.zane.wms.domain.Customer;
import com.zane.wms.pojo.dto.CustomerDTO;
import com.zane.wms.pojo.vo.CustomerVO;
import java.util.List;
/**
 * 客户  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface CustomerConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    CustomerDTO do2dto(Customer source);

    /**
     * @param source DTO
     * @return DO
     */
    Customer dto2do(CustomerDTO source);

    List<CustomerVO> dos2vos(List<Customer> list);
}
