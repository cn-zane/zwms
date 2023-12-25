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
import com.zane.wms.convert.OutStockBillDetailConvert;
import com.zane.wms.domain.OutStockBillDetail;
import com.zane.wms.pojo.query.OutStockBillDetailQuery;
import com.zane.wms.service.OutStockBillDetailService;
import com.zane.wms.pojo.vo.OutStockBillDetailVO;

/**
 * 出库单详情Controller
 *
 * @author zane
 * @date 2023-12-25
 */
@Api(description ="出库单详情接口列表")
@RestController
@RequestMapping("/wms/outStockBillDetail")
public class OutStockBillDetailController extends BaseController {
    @Resource
    private OutStockBillDetailService service;
    @Resource
    private OutStockBillDetailConvert convert;

    @ApiOperation("查询出库单详情列表")
    @PreAuthorize("@ss.hasPermi('wms:outStockBillDetail:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<OutStockBillDetail>> list(@RequestBody OutStockBillDetailQuery query, Pageable page) {
        List<OutStockBillDetail> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出出库单详情列表")
    @PreAuthorize("@ss.hasPermi('wms:outStockBillDetail:export')")
    @Log(title = "出库单详情", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(OutStockBillDetailQuery query) {
        List<OutStockBillDetail> list = service.selectList(query, null);
        ExcelUtil<OutStockBillDetailVO> util = new ExcelUtil<>(OutStockBillDetailVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "出库单详情数据"));
    }

    @ApiOperation("获取出库单详情详细信息")
    @PreAuthorize("@ss.hasPermi('wms:outStockBillDetail:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<OutStockBillDetail> getInfo(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增出库单详情")
    @PreAuthorize("@ss.hasPermi('wms:outStockBillDetail:add')")
    @Log(title = "出库单详情", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody OutStockBillDetail outStockBillDetail) {
        return ResponseEntity.ok(service.insert(outStockBillDetail));
    }

    @ApiOperation("修改出库单详情")
    @PreAuthorize("@ss.hasPermi('wms:outStockBillDetail:edit')")
    @Log(title = "出库单详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody OutStockBillDetail outStockBillDetail) {
        return ResponseEntity.ok(service.update(outStockBillDetail));
    }

    @ApiOperation("删除出库单详情")
    @PreAuthorize("@ss.hasPermi('wms:outStockBillDetail:remove')")
    @Log(title = "出库单详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Long[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
