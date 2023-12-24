package com.zane.wms.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Param;
import com.zane.wms.domain.Inventory;

/**
 * 库存表Mapper接口
 * 
 * @author zane
 */
public interface InventoryMapper extends MPJBaseMapper<Inventory> {
    /**
     * 查询库存表列表
     *
     * @param inventory 库存表
     * @return 库存表集合
     */
    List<Inventory> selectByEntity(Inventory inventory);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
