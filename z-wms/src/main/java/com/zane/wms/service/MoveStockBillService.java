package com.zane.wms.service;

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
import com.zane.wms.mapper.MoveStockBillMapper;
import com.zane.wms.domain.MoveStockBill;
import com.zane.wms.pojo.query.MoveStockBillQuery;

/**
 * 移库单Service业务层处理
 *
 *
 * @author zane
 */
@Service
public class MoveStockBillService {
    @Resource
    private MoveStockBillMapper moveStockBillMapper;

    /**
     * 查询移库单
     *
     * @param id 移库单主键
     * @return 移库单
     */
    public MoveStockBill selectById(Long id) {
        return moveStockBillMapper.selectById(id);
    }

    /**
     * 查询移库单列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 移库单
     */
    public List<MoveStockBill> selectList(MoveStockBillQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<MoveStockBill> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        String moveStockBillNo = query.getMoveStockBillNo();
        if (!StringUtils.isEmpty(moveStockBillNo)) {
            qw.eq("move_stock_bill_no", moveStockBillNo);
        }
        Long outWarehouseId = query.getOutWarehouseId();
        if (outWarehouseId != null) {
            qw.eq("out_warehouse_id", outWarehouseId);
        }
        Long inWarehouseId = query.getInWarehouseId();
        if (inWarehouseId != null) {
            qw.eq("in_warehouse_id", inWarehouseId);
        }
        Integer status = query.getStatus();
        if (status != null) {
            qw.eq("status", status);
        }
        return moveStockBillMapper.selectList(qw);
    }

    /**
     * 新增移库单
     *
     * @param moveStockBill 移库单
     * @return 结果
     */
    public int insert(MoveStockBill moveStockBill) {
        moveStockBill.setDelFlag(0);
    moveStockBill.setCreateBy(SecurityUtils.getUsername());
        moveStockBill.setCreateTime(LocalDateTime.now());
        return moveStockBillMapper.insert(moveStockBill);
    }

    /**
     * 修改移库单
     *
     * @param moveStockBill 移库单
     * @return 结果
     */
    public int update(MoveStockBill moveStockBill) {
                    moveStockBill.setUpdateBy(SecurityUtils.getUsername());
                        moveStockBill.setUpdateTime(LocalDateTime.now());
                                                                                                    return moveStockBillMapper.updateById(moveStockBill);
    }

    /**
     * 批量删除移库单
     *
     * @param ids 需要删除的移库单主键
     * @return 结果
     */
    public int deleteByIds(Long[] ids) {
        return moveStockBillMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除移库单信息
     *
     * @param id 移库单主键
     * @return 结果
     */
    public int deleteById(Long id) {
        Long[] ids = {id};
        return moveStockBillMapper.updateDelFlagByIds(ids);
    }
}
