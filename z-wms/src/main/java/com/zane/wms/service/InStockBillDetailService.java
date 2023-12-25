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
import com.zane.wms.mapper.InStockBillDetailMapper;
import com.zane.wms.domain.InStockBillDetail;
import com.zane.wms.pojo.query.InStockBillDetailQuery;

/**
 * 入库单详情Service业务层处理
 *
 *
 * @author zane
 */
@Service
public class InStockBillDetailService {
    @Resource
    private InStockBillDetailMapper inStockBillDetailMapper;

    /**
     * 查询入库单详情
     *
     * @param id 入库单详情主键
     * @return 入库单详情
     */
    public InStockBillDetail selectById(Long id) {
        return inStockBillDetailMapper.selectById(id);
    }

    /**
     * 查询入库单详情列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 入库单详情
     */
    public List<InStockBillDetail> selectList(InStockBillDetailQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<InStockBillDetail> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        Long inStockBillId = query.getInStockBillId();
        if (inStockBillId != null) {
            qw.eq("in_stock_bill_id", inStockBillId);
        }
        Long matId = query.getMatId();
        if (matId != null) {
            qw.eq("mat_id", matId);
        }
        BigDecimal planQuantity = query.getPlanQuantity();
        if (planQuantity != null) {
            qw.eq("plan_quantity", planQuantity);
        }
        BigDecimal realQuantity = query.getRealQuantity();
        if (realQuantity != null) {
            qw.eq("real_quantity", realQuantity);
        }
        BigDecimal money = query.getMoney();
        if (money != null) {
            qw.eq("money", money);
        }
        String warehouseId = query.getWarehouseId();
        if (!StringUtils.isEmpty(warehouseId)) {
            qw.eq("warehouse_id", warehouseId);
        }
        Integer inStockStatus = query.getInStockStatus();
        if (inStockStatus != null) {
            qw.eq("in_stock_status", inStockStatus);
        }
        return inStockBillDetailMapper.selectList(qw);
    }

    /**
     * 新增入库单详情
     *
     * @param inStockBillDetail 入库单详情
     * @return 结果
     */
    public int insert(InStockBillDetail inStockBillDetail) {
        inStockBillDetail.setDelFlag(0);
    inStockBillDetail.setCreateBy(SecurityUtils.getUsername());
        inStockBillDetail.setCreateTime(LocalDateTime.now());
        return inStockBillDetailMapper.insert(inStockBillDetail);
    }

    /**
     * 修改入库单详情
     *
     * @param inStockBillDetail 入库单详情
     * @return 结果
     */
    public int update(InStockBillDetail inStockBillDetail) {
                    inStockBillDetail.setUpdateBy(SecurityUtils.getUsername());
                        inStockBillDetail.setUpdateTime(LocalDateTime.now());
                                                                                                    return inStockBillDetailMapper.updateById(inStockBillDetail);
    }

    /**
     * 批量删除入库单详情
     *
     * @param ids 需要删除的入库单详情主键
     * @return 结果
     */
    public int deleteByIds(Long[] ids) {
        return inStockBillDetailMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除入库单详情信息
     *
     * @param id 入库单详情主键
     * @return 结果
     */
    public int deleteById(Long id) {
        Long[] ids = {id};
        return inStockBillDetailMapper.updateDelFlagByIds(ids);
    }
}
