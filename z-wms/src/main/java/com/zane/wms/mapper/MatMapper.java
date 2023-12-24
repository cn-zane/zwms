package com.zane.wms.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.zane.wms.domain.Mat;

/**
 * 物料Mapper接口
 * 
 * @author zane
 */
public interface MatMapper extends BaseMapper<Mat> {
    /**
     * 查询物料列表
     *
     * @param mat 物料
     * @return 物料集合
     */
    List<Mat> selectByEntity(Mat mat);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
