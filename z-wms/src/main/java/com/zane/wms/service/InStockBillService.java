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
import com.zane.wms.mapper.InStockBillMapper;
import com.zane.wms.domain.InStockBill;
import com.zane.wms.pojo.query.InStockBillQuery;

/**
 * 入库单Service业务层处理
 *
 *
 * @author zane
 */
@Service
public class InStockBillService {
    @Resource
    private InStockBillMapper inStockBillMapper;

    /**
     * 查询入库单
     *
     * @param id 入库单主键
     * @return 入库单
     */
    public InStockBill selectById(Long id) {
        return inStockBillMapper.selectById(id);
    }

    /**
     * 查询入库单列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 入库单
     */
    public List<InStockBill> selectList(InStockBillQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<InStockBill> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        String inStockBillNo = query.getInStockBillNo();
        if (!StringUtils.isEmpty(inStockBillNo)) {
            qw.eq("in_stock_bill_no", inStockBillNo);
        }
        Integer inStockType = query.getInStockType();
        if (inStockType != null) {
            qw.eq("in_stock_type", inStockType);
        }
        Long supplierId = query.getSupplierId();
        if (supplierId != null) {
            qw.eq("supplier_id", supplierId);
        }
        String orderNo = query.getOrderNo();
        if (!StringUtils.isEmpty(orderNo)) {
            qw.eq("order_no", orderNo);
        }
        BigDecimal payableAmount = query.getPayableAmount();
        if (payableAmount != null) {
            qw.eq("payable_amount", payableAmount);
        }
        Integer inStockStatus = query.getInStockStatus();
        if (inStockStatus != null) {
            qw.eq("in_stock_status", inStockStatus);
        }
        return inStockBillMapper.selectList(qw);
    }

    /**
     * 新增入库单
     *
     * @param inStockBill 入库单
     * @return 结果
     */
    public int insert(InStockBill inStockBill) {
        inStockBill.setDelFlag(0);
    inStockBill.setCreateBy(SecurityUtils.getUsername());
        inStockBill.setCreateTime(LocalDateTime.now());
        return inStockBillMapper.insert(inStockBill);
    }

    /**
     * 修改入库单
     *
     * @param inStockBill 入库单
     * @return 结果
     */
    public int update(InStockBill inStockBill) {
                    inStockBill.setUpdateBy(SecurityUtils.getUsername());
                        inStockBill.setUpdateTime(LocalDateTime.now());
                                                                                            return inStockBillMapper.updateById(inStockBill);
    }

    /**
     * 批量删除入库单
     *
     * @param ids 需要删除的入库单主键
     * @return 结果
     */
    public int deleteByIds(Long[] ids) {
        return inStockBillMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除入库单信息
     *
     * @param id 入库单主键
     * @return 结果
     */
    public int deleteById(Long id) {
        Long[] ids = {id};
        return inStockBillMapper.updateDelFlagByIds(ids);
    }
}
