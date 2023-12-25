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
import com.zane.wms.mapper.OutStockBillMapper;
import com.zane.wms.domain.OutStockBill;
import com.zane.wms.pojo.query.OutStockBillQuery;

/**
 * 出库单Service业务层处理
 *
 *
 * @author zane
 */
@Service
public class OutStockBillService {
    @Resource
    private OutStockBillMapper outStockBillMapper;

    /**
     * 查询出库单
     *
     * @param id 出库单主键
     * @return 出库单
     */
    public OutStockBill selectById(Long id) {
        return outStockBillMapper.selectById(id);
    }

    /**
     * 查询出库单列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 出库单
     */
    public List<OutStockBill> selectList(OutStockBillQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<OutStockBill> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        String outStockBillNo = query.getOutStockBillNo();
        if (!StringUtils.isEmpty(outStockBillNo)) {
            qw.eq("out_stock_bill_no", outStockBillNo);
        }
        Integer outStockType = query.getOutStockType();
        if (outStockType != null) {
            qw.eq("out_stock_type", outStockType);
        }
        String orderNo = query.getOrderNo();
        if (!StringUtils.isEmpty(orderNo)) {
            qw.eq("order_no", orderNo);
        }
        Integer outStockStatus = query.getOutStockStatus();
        if (outStockStatus != null) {
            qw.eq("out_stock_status", outStockStatus);
        }
        return outStockBillMapper.selectList(qw);
    }

    /**
     * 新增出库单
     *
     * @param outStockBill 出库单
     * @return 结果
     */
    public int insert(OutStockBill outStockBill) {
        outStockBill.setDelFlag(0);
    outStockBill.setCreateBy(SecurityUtils.getUsername());
        outStockBill.setCreateTime(LocalDateTime.now());
        return outStockBillMapper.insert(outStockBill);
    }

    /**
     * 修改出库单
     *
     * @param outStockBill 出库单
     * @return 结果
     */
    public int update(OutStockBill outStockBill) {
                    outStockBill.setUpdateBy(SecurityUtils.getUsername());
                        outStockBill.setUpdateTime(LocalDateTime.now());
                                                                                                                    return outStockBillMapper.updateById(outStockBill);
    }

    /**
     * 批量删除出库单
     *
     * @param ids 需要删除的出库单主键
     * @return 结果
     */
    public int deleteByIds(Long[] ids) {
        return outStockBillMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除出库单信息
     *
     * @param id 出库单主键
     * @return 结果
     */
    public int deleteById(Long id) {
        Long[] ids = {id};
        return outStockBillMapper.updateDelFlagByIds(ids);
    }
}
