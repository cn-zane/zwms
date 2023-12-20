package com.zane.wms.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.zane.wms.domain.InventoryMovement;

/**
 * 库存移动Mapper接口
 *
 * @author zane
 */
public interface InventoryMovementMapper extends BaseMapper<InventoryMovement> {
    /**
     * 查询库存移动列表
     *
     * @param inventoryMovement 库存移动
     * @return 库存移动集合
     */
    List<InventoryMovement> selectByEntity(InventoryMovement inventoryMovement);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
