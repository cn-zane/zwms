package com.zane.wms.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import javax.annotation.Resource;
import com.zane.common.utils.SecurityUtils;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.zane.wms.mapper.OutStockBillDetailMapper;
import com.zane.wms.domain.OutStockBillDetail;
import com.zane.wms.pojo.query.OutStockBillDetailQuery;

/**
 * 出库单详情Service业务层处理
 *
 *
 * @author zane
 */
@Service
public class OutStockBillDetailService {
    @Resource
    private OutStockBillDetailMapper outStockBillDetailMapper;

    /**
     * 查询出库单详情
     *
     * @param id 出库单详情主键
     * @return 出库单详情
     */
    public OutStockBillDetail selectById(Long id) {
        return outStockBillDetailMapper.selectById(id);
    }

    /**
     * 查询出库单详情列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 出库单详情
     */
    public List<OutStockBillDetail> selectList(OutStockBillDetailQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<OutStockBillDetail> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        Long outStockBillId = query.getOutStockBillId();
        if (outStockBillId != null) {
            qw.eq("out_stock_bill_id", outStockBillId);
        }
        Long itemId = query.getItemId();
        if (itemId != null) {
            qw.eq("item_id", itemId);
        }
        Long warehouseId = query.getWarehouseId();
        if (warehouseId != null) {
            qw.eq("warehouse_id", warehouseId);
        }
        Integer outStockStatus = query.getOutStockStatus();
        if (outStockStatus != null) {
            qw.eq("out_stock_status", outStockStatus);
        }
        return outStockBillDetailMapper.selectList(qw);
    }

    /**
     * 新增出库单详情
     *
     * @param outStockBillDetail 出库单详情
     * @return 结果
     */
    public int insert(OutStockBillDetail outStockBillDetail) {
        outStockBillDetail.setDelFlag(0);
    outStockBillDetail.setCreateBy(SecurityUtils.getUsername());
        outStockBillDetail.setCreateTime(LocalDateTime.now());
        return outStockBillDetailMapper.insert(outStockBillDetail);
    }

    /**
     * 修改出库单详情
     *
     * @param outStockBillDetail 出库单详情
     * @return 结果
     */
    public int update(OutStockBillDetail outStockBillDetail) {
                    outStockBillDetail.setUpdateBy(SecurityUtils.getUsername());
                        outStockBillDetail.setUpdateTime(LocalDateTime.now());
                                                                                                    return outStockBillDetailMapper.updateById(outStockBillDetail);
    }

    /**
     * 批量删除出库单详情
     *
     * @param ids 需要删除的出库单详情主键
     * @return 结果
     */
    public int deleteByIds(Long[] ids) {
        return outStockBillDetailMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除出库单详情信息
     *
     * @param id 出库单详情主键
     * @return 结果
     */
    public int deleteById(Long id) {
        Long[] ids = {id};
        return outStockBillDetailMapper.updateDelFlagByIds(ids);
    }
}
