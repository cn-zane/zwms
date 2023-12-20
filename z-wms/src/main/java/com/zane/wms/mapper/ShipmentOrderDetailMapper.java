package com.zane.wms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zane.wms.domain.ShipmentOrderDetail;
import com.zane.wms.pojo.vo.ShipmentOrderVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 出库单详情Mapper接口
 *
 * @author zane
 */
public interface ShipmentOrderDetailMapper extends BaseMapper<ShipmentOrderDetail> {
    /**
     * 查询出库单详情列表
     *
     * @param shipmentOrderDetail 出库单详情
     * @return 出库单详情集合
     */
    List<ShipmentOrderDetail> selectByEntity(ShipmentOrderDetail shipmentOrderDetail);

    /**
     * 批量软删除
     *
     * @param ids
     * @return
     */
    int updateDelFlagByIds(@Param("ids") Long[] ids);

    List<ShipmentOrderVO> countByOrderId(List<Long> ids);

    int batchInsert(List<ShipmentOrderDetail> shipmentOrderDetails);

    List<ShipmentOrderDetail> selectListGroupByItemId(@Param("id") long ids);

    List<ShipmentOrderDetail> selectDetailByWaveNo(String waveNo);
}
