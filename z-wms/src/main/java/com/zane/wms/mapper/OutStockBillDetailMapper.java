package com.zane.wms.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.zane.wms.domain.OutStockBillDetail;

/**
 * 出库单详情Mapper接口
 * 
 * @author zane
 */
public interface OutStockBillDetailMapper extends BaseMapper<OutStockBillDetail> {
    /**
     * 查询出库单详情列表
     *
     * @param outStockBillDetail 出库单详情
     * @return 出库单详情集合
     */
    List<OutStockBillDetail> selectByEntity(OutStockBillDetail outStockBillDetail);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
