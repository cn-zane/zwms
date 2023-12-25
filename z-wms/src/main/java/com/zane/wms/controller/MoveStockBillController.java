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
import com.zane.wms.convert.MoveStockBillConvert;
import com.zane.wms.domain.MoveStockBill;
import com.zane.wms.pojo.query.MoveStockBillQuery;
import com.zane.wms.service.MoveStockBillService;
import com.zane.wms.pojo.vo.MoveStockBillVO;

/**
 * 移库单Controller
 *
 * @author zane
 * @date 2023-12-25
 */
@Api(description ="移库单接口列表")
@RestController
@RequestMapping("/wms/moveStockBill")
public class MoveStockBillController extends BaseController {
    @Resource
    private MoveStockBillService service;
    @Resource
    private MoveStockBillConvert convert;

    @ApiOperation("查询移库单列表")
    @PreAuthorize("@ss.hasPermi('wms:moveStockBill:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<MoveStockBill>> list(@RequestBody MoveStockBillQuery query, Pageable page) {
        List<MoveStockBill> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出移库单列表")
    @PreAuthorize("@ss.hasPermi('wms:moveStockBill:export')")
    @Log(title = "移库单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(MoveStockBillQuery query) {
        List<MoveStockBill> list = service.selectList(query, null);
        ExcelUtil<MoveStockBillVO> util = new ExcelUtil<>(MoveStockBillVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "移库单数据"));
    }

    @ApiOperation("获取移库单详细信息")
    @PreAuthorize("@ss.hasPermi('wms:moveStockBill:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<MoveStockBill> getInfo(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增移库单")
    @PreAuthorize("@ss.hasPermi('wms:moveStockBill:add')")
    @Log(title = "移库单", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody MoveStockBill moveStockBill) {
        return ResponseEntity.ok(service.insert(moveStockBill));
    }

    @ApiOperation("修改移库单")
    @PreAuthorize("@ss.hasPermi('wms:moveStockBill:edit')")
    @Log(title = "移库单", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody MoveStockBill moveStockBill) {
        return ResponseEntity.ok(service.update(moveStockBill));
    }

    @ApiOperation("删除移库单")
    @PreAuthorize("@ss.hasPermi('wms:moveStockBill:remove')")
    @Log(title = "移库单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Long[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
