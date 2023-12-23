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
import com.zane.wms.convert.MatTypeConvert;
import com.zane.wms.domain.MatType;
import com.zane.wms.pojo.query.MatTypeQuery;
import com.zane.wms.service.MatTypeService;
import com.zane.wms.pojo.vo.MatTypeVO;

/**
 * 物料类型Controller
 *
 * @author zane
 * @date 2023-12-23
 */
@Api(description ="物料类型接口列表")
@RestController
@RequestMapping("/wms/matType")
public class MatTypeController extends BaseController {
    @Resource
    private MatTypeService service;
    @Resource
    private MatTypeConvert convert;

    @ApiOperation("查询物料类型列表")
    @PreAuthorize("@ss.hasPermi('wms:matType:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<MatType>> list(@RequestBody MatTypeQuery query, Pageable page) {
        List<MatType> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出物料类型列表")
    @PreAuthorize("@ss.hasPermi('wms:matType:export')")
    @Log(title = "物料类型", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(MatTypeQuery query) {
        List<MatType> list = service.selectList(query, null);
        ExcelUtil<MatTypeVO> util = new ExcelUtil<>(MatTypeVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "物料类型数据"));
    }

    @ApiOperation("获取物料类型详细信息")
    @PreAuthorize("@ss.hasPermi('wms:matType:query')")
    @GetMapping(value = "/{matTypeId}")
    public ResponseEntity<MatType> getInfo(@PathVariable("matTypeId") Long matTypeId) {
        return ResponseEntity.ok(service.selectByMatTypeId(matTypeId));
    }

    @ApiOperation("新增物料类型")
    @PreAuthorize("@ss.hasPermi('wms:matType:add')")
    @Log(title = "物料类型", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody MatType matType) {
        return ResponseEntity.ok(service.insert(matType));
    }

    @ApiOperation("修改物料类型")
    @PreAuthorize("@ss.hasPermi('wms:matType:edit')")
    @Log(title = "物料类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody MatType matType) {
        return ResponseEntity.ok(service.update(matType));
    }

    @ApiOperation("删除物料类型")
    @PreAuthorize("@ss.hasPermi('wms:matType:remove')")
    @Log(title = "物料类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{matTypeIds}")
    public ResponseEntity<Integer> remove(@PathVariable Long[] matTypeIds) {
        return ResponseEntity.ok(service.deleteByMatTypeIds(matTypeIds));
    }
}
