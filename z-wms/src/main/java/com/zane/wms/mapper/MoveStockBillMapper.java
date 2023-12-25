package com.zane.wms.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.zane.wms.domain.MoveStockBill;

/**
 * 移库单Mapper接口
 * 
 * @author zane
 */
public interface MoveStockBillMapper extends BaseMapper<MoveStockBill> {
    /**
     * 查询移库单列表
     *
     * @param moveStockBill 移库单
     * @return 移库单集合
     */
    List<MoveStockBill> selectByEntity(MoveStockBill moveStockBill);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
