package com.zane.wms.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import com.zane.common.annotation.Log;
import com.zane.common.core.controller.BaseController;
import com.zane.common.enums.BusinessType;
import com.zane.common.utils.poi.ExcelUtil;
import com.zane.wms.convert.MatConvert;
import com.zane.wms.domain.Mat;
import com.zane.wms.pojo.query.MatQuery;
import com.zane.wms.service.MatService;
import com.zane.wms.pojo.vo.MatVO;

/**
 * 物料Controller
 *
 * @author zane
 * @date 2023-12-24
 */
@Api(description ="物料接口列表")
@RestController
@RequestMapping("/wms/mat")
public class MatController extends BaseController {
    @Resource
    private MatService service;
    @Resource
    private MatConvert convert;

    @ApiOperation("查询物料列表")
    @PreAuthorize("@ss.hasPermi('wms:mat:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<Mat>> list(@RequestBody MatQuery query, Pageable page) {
        List<Mat> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出物料列表")
    @PreAuthorize("@ss.hasPermi('wms:mat:export')")
    @Log(title = "物料", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(MatQuery query) {
        List<Mat> list = service.selectList(query, null);
        ExcelUtil<MatVO> util = new ExcelUtil<>(MatVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "物料数据"));
    }

    @ApiOperation("获取物料详细信息")
    @PreAuthorize("@ss.hasPermi('wms:mat:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Mat> getInfo(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增物料")
    @PreAuthorize("@ss.hasPermi('wms:mat:add')")
    @Log(title = "物料", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody Mat mat) {
        return ResponseEntity.ok(service.insert(mat));
    }

    @ApiOperation("修改物料")
    @PreAuthorize("@ss.hasPermi('wms:mat:edit')")
    @Log(title = "物料", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody Mat mat) {
        return ResponseEntity.ok(service.update(mat));
    }

    @ApiOperation("删除物料")
    @PreAuthorize("@ss.hasPermi('wms:mat:remove')")
    @Log(title = "物料", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Long[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
