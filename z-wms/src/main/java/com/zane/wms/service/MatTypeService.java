package com.zane.wms.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import javax.annotation.Resource;

import com.zane.common.utils.SecurityUtils;
import org.springframework.data.domain.Pageable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.zane.wms.mapper.MatTypeMapper;
import com.zane.wms.domain.MatType;
import com.zane.wms.pojo.query.MatTypeQuery;

/**
 * 物料类型Service业务层处理
 *
 *
 * @author zane
 */
@Service
public class MatTypeService {
    @Resource
    private MatTypeMapper matTypeMapper;

    /**
     * 查询物料类型
     *
     * @param matTypeId 物料类型主键
     * @return 物料类型
     */
    public MatType selectByMatTypeId(Long matTypeId) {
        return matTypeMapper.selectOne(new QueryWrapper<MatType>().eq("mat_type_id", matTypeId));
    }

    /**
     * 查询物料类型列表
     *
     * @param query 查询条件
     * @param page 分页条件
     * @return 物料类型
     */
    public List<MatType> selectList(MatTypeQuery query, Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        QueryWrapper<MatType> qw = new QueryWrapper<>();
        qw.eq("del_flag",0);
        String matTypeNameLike = query.getMatTypeNameLike();
        if (!StringUtils.isEmpty(matTypeNameLike)) {
            qw.like("mat_type_name", matTypeNameLike);
        }
        Integer sort = query.getSort();
        if (sort != null) {
            qw.eq("sort", sort);
        }
        Integer status = query.getStatus();
        if (status != null) {
            qw.eq("status", status);
        }
        return matTypeMapper.selectList(qw);
    }

    /**
     * 新增物料类型
     *
     * @param matType 物料类型
     * @return 结果
     */
    public int insert(MatType matType) {
        matType.setDelFlag(0);
        matType.setCreateBy(SecurityUtils.getUsername());
        matType.setCreateTime(LocalDateTime.now());
        return matTypeMapper.insert(matType);
    }

    /**
     * 修改物料类型
     *
     * @param matType 物料类型
     * @return 结果
     */
    public int update(MatType matType) {
        return matTypeMapper.update(matType, new UpdateWrapper<MatType>().eq("mat_type_id", matType.getMatTypeId()));
    }

    /**
     * 批量删除物料类型
     *
     * @param matTypeIds 需要删除的物料类型主键
     * @return 结果
     */
    public int deleteByMatTypeIds(Long[] matTypeIds) {
        return matTypeMapper.updateDelFlagByIds(matTypeIds);
    }

    /**
     * 删除物料类型信息
     *
     * @param matTypeId 物料类型主键
     * @return 结果
     */
    public int deleteByMatTypeId(Long matTypeId) {
        Long[] matTypeIds = {matTypeId};
        return matTypeMapper.updateDelFlagByIds(matTypeIds);
    }
}
