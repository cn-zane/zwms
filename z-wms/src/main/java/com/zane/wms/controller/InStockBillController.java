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
import com.zane.wms.convert.InStockBillConvert;
import com.zane.wms.domain.InStockBill;
import com.zane.wms.pojo.query.InStockBillQuery;
import com.zane.wms.service.InStockBillService;
import com.zane.wms.pojo.vo.InStockBillVO;

/**
 * 入库单Controller
 *
 * @author zane
 * @date 2023-12-25
 */
@Api(description ="入库单接口列表")
@RestController
@RequestMapping("/wms/inStockBill")
public class InStockBillController extends BaseController {
    @Resource
    private InStockBillService service;
    @Resource
    private InStockBillConvert convert;

    @ApiOperation("查询入库单列表")
    @PreAuthorize("@ss.hasPermi('wms:inStockBill:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<InStockBill>> list(@RequestBody InStockBillQuery query, Pageable page) {
        List<InStockBill> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出入库单列表")
    @PreAuthorize("@ss.hasPermi('wms:inStockBill:export')")
    @Log(title = "入库单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(InStockBillQuery query) {
        List<InStockBill> list = service.selectList(query, null);
        ExcelUtil<InStockBillVO> util = new ExcelUtil<>(InStockBillVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "入库单数据"));
    }

    @ApiOperation("获取入库单详细信息")
    @PreAuthorize("@ss.hasPermi('wms:inStockBill:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<InStockBill> getInfo(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增入库单")
    @PreAuthorize("@ss.hasPermi('wms:inStockBill:add')")
    @Log(title = "入库单", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody InStockBill inStockBill) {
        return ResponseEntity.ok(service.insert(inStockBill));
    }

    @ApiOperation("修改入库单")
    @PreAuthorize("@ss.hasPermi('wms:inStockBill:edit')")
    @Log(title = "入库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody InStockBill inStockBill) {
        return ResponseEntity.ok(service.update(inStockBill));
    }

    @ApiOperation("删除入库单")
    @PreAuthorize("@ss.hasPermi('wms:inStockBill:remove')")
    @Log(title = "入库单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Long[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
