package com.zane.wms.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.zane.wms.domain.OutStockBill;

/**
 * 出库单Mapper接口
 * 
 * @author zane
 */
public interface OutStockBillMapper extends BaseMapper<OutStockBill> {
    /**
     * 查询出库单列表
     *
     * @param outStockBill 出库单
     * @return 出库单集合
     */
    List<OutStockBill> selectByEntity(OutStockBill outStockBill);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
