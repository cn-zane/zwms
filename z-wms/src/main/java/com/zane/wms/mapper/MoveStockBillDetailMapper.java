package com.zane.wms.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.zane.wms.domain.MoveStockBillDetail;

/**
 * 移库单详情Mapper接口
 * 
 * @author zane
 */
public interface MoveStockBillDetailMapper extends BaseMapper<MoveStockBillDetail> {
    /**
     * 查询移库单详情列表
     *
     * @param moveStockBillDetail 移库单详情
     * @return 移库单详情集合
     */
    List<MoveStockBillDetail> selectByEntity(MoveStockBillDetail moveStockBillDetail);

    /**
     * 批量软删除
     * @param ids
     * @return
    */
    int updateDelFlagByIds(@Param("ids") Long[] ids);
}
