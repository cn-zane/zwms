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
import com.zane.wms.mapper.WarehouseMapper;
import com.zane.wms.domain.Warehouse;
import com.zane.wms.pojo.query.WarehouseQuery;

/**
 * 仓库Service业务层处理
 *
 *
 * @author zane
 */
@Service
public class WarehouseService {
    @Resource
    private WarehouseMapper warehouseMapper;

    /**
     * 查询仓库
     *
     * @param id 仓库主键
     * @return 仓库
     */
    public Warehouse selectById(Long id) {
        return warehouseMapper.selectById(id);
    }

    /**
     * 查询仓库列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 仓库
     */
    public List<Warehouse> selectList(WarehouseQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<Warehouse> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        String warehouseNo = query.getWarehouseNo();
        if (!StringUtils.isEmpty(warehouseNo)) {
            qw.eq("warehouse_no", warehouseNo);
        }
        String warehouseNameLike = query.getWarehouseNameLike();
        if (!StringUtils.isEmpty(warehouseNameLike)) {
            qw.like("warehouse_name", warehouseNameLike);
        }
        return warehouseMapper.selectList(qw);
    }

    /**
     * 新增仓库
     *
     * @param warehouse 仓库
     * @return 结果
     */
    public int insert(Warehouse warehouse) {
        warehouse.setDelFlag(0);
        warehouse.setCreateBy(SecurityUtils.getUsername());
        warehouse.setCreateTime(LocalDateTime.now());
        return warehouseMapper.insert(warehouse);
    }

    /**
     * 修改仓库
     *
     * @param warehouse 仓库
     * @return 结果
     */
    public int update(Warehouse warehouse) {
        return warehouseMapper.updateById(warehouse);
    }

    /**
     * 批量删除仓库
     *
     * @param ids 需要删除的仓库主键
     * @return 结果
     */
    public int deleteByIds(Long[] ids) {
        return warehouseMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除仓库信息
     *
     * @param id 仓库主键
     * @return 结果
     */
    public int deleteById(Long id) {
        Long[] ids = {id};
        return warehouseMapper.updateDelFlagByIds(ids);
    }
}
