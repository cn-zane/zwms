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
import com.zane.wms.convert.OutStockBillConvert;
import com.zane.wms.domain.OutStockBill;
import com.zane.wms.pojo.query.OutStockBillQuery;
import com.zane.wms.service.OutStockBillService;
import com.zane.wms.pojo.vo.OutStockBillVO;

/**
 * 出库单Controller
 *
 * @author zane
 * @date 2023-12-25
 */
@Api(description ="出库单接口列表")
@RestController
@RequestMapping("/wms/outStockBill")
public class OutStockBillController extends BaseController {
    @Resource
    private OutStockBillService service;
    @Resource
    private OutStockBillConvert convert;

    @ApiOperation("查询出库单列表")
    @PreAuthorize("@ss.hasPermi('wms:outStockBill:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<OutStockBill>> list(@RequestBody OutStockBillQuery query, Pageable page) {
        List<OutStockBill> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出出库单列表")
    @PreAuthorize("@ss.hasPermi('wms:outStockBill:export')")
    @Log(title = "出库单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(OutStockBillQuery query) {
        List<OutStockBill> list = service.selectList(query, null);
        ExcelUtil<OutStockBillVO> util = new ExcelUtil<>(OutStockBillVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "出库单数据"));
    }

    @ApiOperation("获取出库单详细信息")
    @PreAuthorize("@ss.hasPermi('wms:outStockBill:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<OutStockBill> getInfo(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增出库单")
    @PreAuthorize("@ss.hasPermi('wms:outStockBill:add')")
    @Log(title = "出库单", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody OutStockBill outStockBill) {
        return ResponseEntity.ok(service.insert(outStockBill));
    }

    @ApiOperation("修改出库单")
    @PreAuthorize("@ss.hasPermi('wms:outStockBill:edit')")
    @Log(title = "出库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody OutStockBill outStockBill) {
        return ResponseEntity.ok(service.update(outStockBill));
    }

    @ApiOperation("删除出库单")
    @PreAuthorize("@ss.hasPermi('wms:outStockBill:remove')")
    @Log(title = "出库单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Long[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
