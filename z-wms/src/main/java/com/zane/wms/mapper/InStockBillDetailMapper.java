package com.zane.wms.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.zane.wms.domain.InStockBillDetail;

/**
 * 入库单详情Mapper接口
 * 
 * @author zane
 */
public interface InStockBillDetailMapper extends BaseMapper<InStockBillDetail> {
    /**
     * 查询入库单详情列表
     *
     * @param inStockBillDetail 入库单详情
     * @return 入库单详情集合
     */
    List<InStockBillDetail> selectByEntity(InStockBillDetail inStockBillDetail);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
