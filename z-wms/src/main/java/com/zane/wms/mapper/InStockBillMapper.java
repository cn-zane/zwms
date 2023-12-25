package com.zane.wms.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.zane.wms.domain.InStockBill;

/**
 * 入库单Mapper接口
 * 
 * @author zane
 */
public interface InStockBillMapper extends BaseMapper<InStockBill> {
    /**
     * 查询入库单列表
     *
     * @param inStockBill 入库单
     * @return 入库单集合
     */
    List<InStockBill> selectByEntity(InStockBill inStockBill);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
