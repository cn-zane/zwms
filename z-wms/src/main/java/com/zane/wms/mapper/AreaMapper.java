package com.zane.wms.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zane.wms.domain.Area;
import org.apache.ibatis.annotations.Param;

/**
 * 货区Mapper接口
 *
 * @author zane
 */
public interface AreaMapper extends BaseMapper<Area> {
    /**
     * 查询货区列表
     *
     * @param area 货区
     * @return 货区集合
     */
    List<Area> selectByEntity(Area area);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}