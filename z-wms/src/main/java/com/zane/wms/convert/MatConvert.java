package com.zane.wms.convert;

import org.mapstruct.Mapper;
import com.zane.wms.domain.Mat;
import com.zane.wms.pojo.dto.MatDTO;
import com.zane.wms.pojo.vo.MatVO;
import java.util.List;
/**
 * 物料  DO <=> DTO <=> VO / BO / Query
 *
 * @author zane
 */
@Mapper(componentModel = "spring")
public interface MatConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    MatDTO do2dto(Mat source);

    /**
     * @param source DTO
     * @return DO
     */
    Mat dto2do(MatDTO source);

    List<MatVO> dos2vos(List<Mat> list);
}
