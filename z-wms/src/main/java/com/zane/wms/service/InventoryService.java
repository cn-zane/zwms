package com.zane.wms.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import javax.annotation.Resource;

import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.zane.common.utils.SecurityUtils;
import com.zane.wms.domain.Mat;
import com.zane.wms.pojo.dto.InventoryDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.zane.wms.mapper.InventoryMapper;
import com.zane.wms.domain.Inventory;
import com.zane.wms.pojo.query.InventoryQuery;

/**
 * 库存表Service业务层处理
 *
 *
 * @author zane
 */
@Service
public class InventoryService {
    @Resource
    private InventoryMapper inventoryMapper;

    /**
     * 查询库存表
     *
     * @param id 库存表主键
     * @return 库存表
     */
    public Inventory selectById(Long id) {
        return inventoryMapper.selectById(id);
    }

    /**
     * 查询库存表列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 库存表
     */
    public List<Inventory> selectList(InventoryQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<Inventory> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        Long matId = query.getMatId();
        if (matId != null) {
            qw.eq("mat_id", matId);
        }
        BigDecimal quantity = query.getQuantity();
        if (quantity != null) {
            qw.eq("quantity", quantity);
        }
        Long warehouseId = query.getWarehouseId();
        if (warehouseId != null) {
            qw.eq("warehouse_id", warehouseId);
        }
        return inventoryMapper.selectList(qw);
    }
    
    /**
     * 查询库存表列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 库存表
     */
    public List<InventoryDTO> selectListDto(InventoryQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        MPJLambdaWrapper<Inventory> qw = JoinWrappers.lambda(Inventory.class)
                                                 .selectAll(Inventory.class)
                                                 .selectAs(Mat::getMatName, Mat::getMatName)
                                                 .leftJoin(Mat.class, Mat::getId, Inventory::getMatId);
        qw.eq("t.del_flag",0);
        Long matId = query.getMatId();
        if (matId != null) {
            qw.eq("t.mat_id", matId);
        }
        BigDecimal quantity = query.getQuantity();
        if (quantity != null) {
            qw.eq("t.quantity", quantity);
        }
        Long warehouseId = query.getWarehouseId();
        if (warehouseId != null) {
            qw.eq("t.warehouse_id", warehouseId);
        }
        
        return inventoryMapper.selectJoinList(InventoryDTO.class, qw);
    }

    /**
     * 新增库存表
     *
     * @param inventory 库存表
     * @return 结果
     */
    public int insert(Inventory inventory) {
        inventory.setDelFlag(0);
    inventory.setCreateBy(SecurityUtils.getUsername());
        inventory.setCreateTime(LocalDateTime.now());
        return inventoryMapper.insert(inventory);
    }

    /**
     * 修改库存表
     *
     * @param inventory 库存表
     * @return 结果
     */
    public int update(Inventory inventory) {
                    inventory.setUpdateBy(SecurityUtils.getUsername());
                        inventory.setUpdateTime(LocalDateTime.now());
                                                                    return inventoryMapper.updateById(inventory);
    }

    /**
     * 批量删除库存表
     *
     * @param ids 需要删除的库存表主键
     * @return 结果
     */
    public int deleteByIds(Long[] ids) {
        return inventoryMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除库存表信息
     *
     * @param id 库存表主键
     * @return 结果
     */
    public int deleteById(Long id) {
        Long[] ids = {id};
        return inventoryMapper.updateDelFlagByIds(ids);
    }
}
