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
import com.zane.wms.convert.InStockBillDetailConvert;
import com.zane.wms.domain.InStockBillDetail;
import com.zane.wms.pojo.query.InStockBillDetailQuery;
import com.zane.wms.service.InStockBillDetailService;
import com.zane.wms.pojo.vo.InStockBillDetailVO;

/**
 * 入库单详情Controller
 *
 * @author zane
 * @date 2023-12-25
 */
@Api(description ="入库单详情接口列表")
@RestController
@RequestMapping("/wms/inStockBillDetail")
public class InStockBillDetailController extends BaseController {
    @Resource
    private InStockBillDetailService service;
    @Resource
    private InStockBillDetailConvert convert;

    @ApiOperation("查询入库单详情列表")
    @PreAuthorize("@ss.hasPermi('wms:inStockBillDetail:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<InStockBillDetail>> list(@RequestBody InStockBillDetailQuery query, Pageable page) {
        List<InStockBillDetail> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出入库单详情列表")
    @PreAuthorize("@ss.hasPermi('wms:inStockBillDetail:export')")
    @Log(title = "入库单详情", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(InStockBillDetailQuery query) {
        List<InStockBillDetail> list = service.selectList(query, null);
        ExcelUtil<InStockBillDetailVO> util = new ExcelUtil<>(InStockBillDetailVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "入库单详情数据"));
    }

    @ApiOperation("获取入库单详情详细信息")
    @PreAuthorize("@ss.hasPermi('wms:inStockBillDetail:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<InStockBillDetail> getInfo(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增入库单详情")
    @PreAuthorize("@ss.hasPermi('wms:inStockBillDetail:add')")
    @Log(title = "入库单详情", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody InStockBillDetail inStockBillDetail) {
        return ResponseEntity.ok(service.insert(inStockBillDetail));
    }

    @ApiOperation("修改入库单详情")
    @PreAuthorize("@ss.hasPermi('wms:inStockBillDetail:edit')")
    @Log(title = "入库单详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody InStockBillDetail inStockBillDetail) {
        return ResponseEntity.ok(service.update(inStockBillDetail));
    }

    @ApiOperation("删除入库单详情")
    @PreAuthorize("@ss.hasPermi('wms:inStockBillDetail:remove')")
    @Log(title = "入库单详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Long[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
