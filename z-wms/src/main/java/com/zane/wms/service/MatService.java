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
import com.zane.wms.mapper.MatMapper;
import com.zane.wms.domain.Mat;
import com.zane.wms.pojo.query.MatQuery;

/**
 * 物料Service业务层处理
 *
 *
 * @author zane
 */
@Service
public class MatService {
    @Resource
    private MatMapper matMapper;

    /**
     * 查询物料
     *
     * @param id 物料主键
     * @return 物料
     */
    public Mat selectById(Long id) {
        return matMapper.selectById(id);
    }

    /**
     * 查询物料列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 物料
     */
    public List<Mat> selectList(MatQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<Mat> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        String matNo = query.getMatNo();
        if (!StringUtils.isEmpty(matNo)) {
            qw.eq("mat_no", matNo);
        }
        String matNameLike = query.getMatNameLike();
        if (!StringUtils.isEmpty(matNameLike)) {
            qw.like("mat_name", matNameLike);
        }
        String specification = query.getSpecification();
        if (!StringUtils.isEmpty(specification)) {
            qw.eq("specification", specification);
        }
        String matType = query.getMatType();
        if (!StringUtils.isEmpty(matType)) {
            qw.eq("mat_type", matType);
        }
        String unit = query.getUnit();
        if (!StringUtils.isEmpty(unit)) {
            qw.eq("unit", unit);
        }
        BigDecimal unitPrice = query.getUnitPrice();
        if (unitPrice != null) {
            qw.eq("unit_price", unitPrice);
        }
        String warehouseId = query.getWarehouseId();
        if (!StringUtils.isEmpty(warehouseId)) {
            qw.eq("warehouse_id", warehouseId);
        }
        BigDecimal quantity = query.getQuantity();
        if (quantity != null) {
            qw.eq("quantity", quantity);
        }
        LocalDateTime productionDate = query.getProductionDate();
        if (productionDate != null) {
            qw.eq("production_date", productionDate);
        }
        LocalDateTime expiryDate = query.getExpiryDate();
        if (expiryDate != null) {
            qw.eq("expiry_date", expiryDate);
        }
        String batch = query.getBatch();
        if (!StringUtils.isEmpty(batch)) {
            qw.eq("batch", batch);
        }
        return matMapper.selectList(qw);
    }

    /**
     * 新增物料
     *
     * @param mat 物料
     * @return 结果
     */
    public int insert(Mat mat) {
        mat.setDelFlag(0);
    mat.setCreateBy(SecurityUtils.getUsername());
        mat.setCreateTime(LocalDateTime.now());
        return matMapper.insert(mat);
    }

    /**
     * 修改物料
     *
     * @param mat 物料
     * @return 结果
     */
    public int update(Mat mat) {
                    mat.setUpdateBy(SecurityUtils.getUsername());
                        mat.setUpdateTime(LocalDateTime.now());
                                                                                                                                    return matMapper.updateById(mat);
    }

    /**
     * 批量删除物料
     *
     * @param ids 需要删除的物料主键
     * @return 结果
     */
    public int deleteByIds(Long[] ids) {
        return matMapper.updateDelFlagByIds(ids);
    }

    /**
     * 删除物料信息
     *
     * @param id 物料主键
     * @return 结果
     */
    public int deleteById(Long id) {
        Long[] ids = {id};
        return matMapper.updateDelFlagByIds(ids);
    }
}
