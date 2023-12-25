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
import com.zane.wms.mapper.MoveStockBillDetailMapper;
import com.zane.wms.domain.MoveStockBillDetail;
import com.zane.wms.pojo.query.MoveStockBillDetailQuery;

/**
 * 移库单详情Service业务层处理
 *
 *
 * @author zane
 */
@Service
public class MoveStockBillDetailService {
    @Resource
    private MoveStockBillDetailMapper moveStockBillDetailMapper;

    /**
     * 查询移库单详情
     *
     * @param id 移库单详情主键
     * @return 移库单详情
     */
    public MoveStockBillDetail selectById(Long id) {
        return moveStockBillDetailMapper.selectById(id);
    }

    /**
     * 查询移库单详情列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 移库单详情
     */
    public List<MoveStockBillDetail> selectList(MoveStockBillDetailQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<MoveStockBillDetail> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        Long moveStockId = query.getMoveStockId();
        if (moveStockId != null) {
            qw.eq("move_stock_id", moveStockId);
        }
        Long itemId = query.getItemId();
        if (itemId != null) {
            qw.eq("item_id", itemId);
        }
        Long outWarehouseId = query.getOutWarehouseId();
        if (outWarehouseId != null) {
            qw.eq("out_warehouse_id", outWarehouseId);
        }
        Long inWarehouseId = query.getInWarehouseId();
        if (inWarehouseId != null) {
            qw.eq("in_warehouse_id", inWarehouseId);
        }
        Integer moveStatus = query.getMoveStatus();
        if (moveStatus != null) {
            qw.eq("move_status", moveStatus);
        }
        return moveStockBillDetailMapper.selectList(qw);
    }

    /**
     * 新增移库单详情
     *
     * @param moveStockBillDetail 移库单详情
     * @return 结果
     */
    public int insert(MoveStockBillDetail moveStockBillDetail) {
        moveStockBillDetail.setDelFlag(0);
    moveStockBillDetail.setCreateBy(SecurityUtils.getUsername());
        moveStockBillDetail.setCreateTime(LocalDateTime.now());
        return moveStockBillDetailMapper.insert(moveStockBillDetail);
    }

    /**
     * 修改移库单详情
     *
     * @param moveStockBillDetail 移库单详情
     * @return 结果
     */
    public int update(MoveStockBillDetail moveStockBillDetail) {
                    moveStockBillDetail.setUpdateBy(SecurityUtils.getUsername());
                        moveStockBillDetail.setUpdateTime(LocalDateTime.now());
                                                                                                    return moveStockBillDetailMapper.updateById(moveStockBillDetail);
    }

    /**
     * 批量删除移库单详情
     *
     * @param ids 需要删除的移库单详情主键
     * @return 结果
     */
    public int deleteByIds(Long[] ids) {
        return moveStockBillDetailMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除移库单详情信息
     *
     * @param id 移库单详情主键
     * @return 结果
     */
    public int deleteById(Long id) {
        Long[] ids = {id};
        return moveStockBillDetailMapper.updateDelFlagByIds(ids);
    }
}
