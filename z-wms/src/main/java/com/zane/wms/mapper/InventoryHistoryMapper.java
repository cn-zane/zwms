package com.zane.wms.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.zane.wms.domain.InventoryHistory;

/**
 * 库存记录Mapper接口
 * 
 * @author zane
 */
public interface InventoryHistoryMapper extends BaseMapper<InventoryHistory> {
    /**
     * 查询库存记录列表
     *
     * @param inventoryHistory 库存记录
     * @return 库存记录集合
     */
    List<InventoryHistory> selectByEntity(InventoryHistory inventoryHistory);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
