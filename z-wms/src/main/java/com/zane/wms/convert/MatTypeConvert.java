package com.zane.wms.convert;

import org.mapstruct.Mapper;
import com.zane.wms.domain.MatType;
import com.zane.wms.pojo.dto.MatTypeDTO;
import com.zane.wms.pojo.vo.MatTypeVO;
import java.util.List;
/**
 * 物料类型  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface MatTypeConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    MatTypeDTO do2dto(MatType source);

    /**
     * @param source DTO
     * @return DO
     */
    MatType dto2do(MatTypeDTO source);

    List<MatTypeVO> dos2vos(List<MatType> list);
}
