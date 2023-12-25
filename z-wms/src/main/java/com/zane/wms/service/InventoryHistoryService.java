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
import com.zane.wms.mapper.InventoryHistoryMapper;
import com.zane.wms.domain.InventoryHistory;
import com.zane.wms.pojo.query.InventoryHistoryQuery;

/**
 * 库存记录Service业务层处理
 *
 *
 * @author zane
 */
@Service
public class InventoryHistoryService {
    @Resource
    private InventoryHistoryMapper inventoryHistoryMapper;

    /**
     * 查询库存记录
     *
     * @param id 库存记录主键
     * @return 库存记录
     */
    public InventoryHistory selectById(Long id) {
        return inventoryHistoryMapper.selectById(id);
    }

    /**
     * 查询库存记录列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 库存记录
     */
    public List<InventoryHistory> selectList(InventoryHistoryQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<InventoryHistory> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        Long formId = query.getFormId();
        if (formId != null) {
            qw.eq("form_id", formId);
        }
        Integer actionType = query.getActionType();
        if (actionType != null) {
            qw.eq("action_type", actionType);
        }
        Long itemId = query.getItemId();
        if (itemId != null) {
            qw.eq("item_id", itemId);
        }
        BigDecimal quantity = query.getQuantity();
        if (quantity != null) {
            qw.eq("quantity", quantity);
        }
        Long warehouseId = query.getWarehouseId();
        if (warehouseId != null) {
            qw.eq("warehouse_id", warehouseId);
        }
        return inventoryHistoryMapper.selectList(qw);
    }

    /**
     * 新增库存记录
     *
     * @param inventoryHistory 库存记录
     * @return 结果
     */
    public int insert(InventoryHistory inventoryHistory) {
        inventoryHistory.setDelFlag(0);
    inventoryHistory.setCreateBy(SecurityUtils.getUsername());
        inventoryHistory.setCreateTime(LocalDateTime.now());
        return inventoryHistoryMapper.insert(inventoryHistory);
    }

    /**
     * 修改库存记录
     *
     * @param inventoryHistory 库存记录
     * @return 结果
     */
    public int update(InventoryHistory inventoryHistory) {
                    inventoryHistory.setUpdateBy(SecurityUtils.getUsername());
                        inventoryHistory.setUpdateTime(LocalDateTime.now());
                                                                                    return inventoryHistoryMapper.updateById(inventoryHistory);
    }

    /**
     * 批量删除库存记录
     *
     * @param ids 需要删除的库存记录主键
     * @return 结果
     */
    public int deleteByIds(Long[] ids) {
        return inventoryHistoryMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除库存记录信息
     *
     * @param id 库存记录主键
     * @return 结果
     */
    public int deleteById(Long id) {
        Long[] ids = {id};
        return inventoryHistoryMapper.updateDelFlagByIds(ids);
    }
}
