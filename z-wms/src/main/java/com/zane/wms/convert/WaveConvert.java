package com.zane.wms.convert;

import com.zane.wms.pojo.dto.WaveDTO;
import com.zane.wms.pojo.vo.WaveVO;
import org.mapstruct.Mapper;
import com.zane.wms.domain.Wave;

import java.util.List;
/**
 * 波次  DO <=> DTO <=> VO / BO / Query
 *
 * @author zhangcheng
 */
@Mapper(componentModel = "spring")
public interface WaveConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    WaveDTO do2dto(Wave source);

    /**
     * @param source DTO
     * @return DO
     */
    Wave dto2do(WaveDTO source);

    List<WaveVO> dos2vos(List<Wave> list);
}
