package com.zane.wms.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.zane.wms.domain.MatType;

/**
 * 物料类型Mapper接口
 * 
 * @author zane
 */
public interface MatTypeMapper extends BaseMapper<MatType> {
    /**
     * 查询物料类型列表
     *
     * @param matType 物料类型
     * @return 物料类型集合
     */
    List<MatType> selectByEntity(MatType matType);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
