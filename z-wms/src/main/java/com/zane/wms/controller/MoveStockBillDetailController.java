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
import com.zane.wms.convert.MoveStockBillDetailConvert;
import com.zane.wms.domain.MoveStockBillDetail;
import com.zane.wms.pojo.query.MoveStockBillDetailQuery;
import com.zane.wms.service.MoveStockBillDetailService;
import com.zane.wms.pojo.vo.MoveStockBillDetailVO;

/**
 * 移库单详情Controller
 *
 * @author zane
 * @date 2023-12-25
 */
@Api(description ="移库单详情接口列表")
@RestController
@RequestMapping("/wms/moveStockBillDetail")
public class MoveStockBillDetailController extends BaseController {
    @Resource
    private MoveStockBillDetailService service;
    @Resource
    private MoveStockBillDetailConvert convert;

    @ApiOperation("查询移库单详情列表")
    @PreAuthorize("@ss.hasPermi('wms:moveStockBillDetail:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<MoveStockBillDetail>> list(@RequestBody MoveStockBillDetailQuery query, Pageable page) {
        List<MoveStockBillDetail> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出移库单详情列表")
    @PreAuthorize("@ss.hasPermi('wms:moveStockBillDetail:export')")
    @Log(title = "移库单详情", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(MoveStockBillDetailQuery query) {
        List<MoveStockBillDetail> list = service.selectList(query, null);
        ExcelUtil<MoveStockBillDetailVO> util = new ExcelUtil<>(MoveStockBillDetailVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "移库单详情数据"));
    }

    @ApiOperation("获取移库单详情详细信息")
    @PreAuthorize("@ss.hasPermi('wms:moveStockBillDetail:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<MoveStockBillDetail> getInfo(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增移库单详情")
    @PreAuthorize("@ss.hasPermi('wms:moveStockBillDetail:add')")
    @Log(title = "移库单详情", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody MoveStockBillDetail moveStockBillDetail) {
        return ResponseEntity.ok(service.insert(moveStockBillDetail));
    }

    @ApiOperation("修改移库单详情")
    @PreAuthorize("@ss.hasPermi('wms:moveStockBillDetail:edit')")
    @Log(title = "移库单详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody MoveStockBillDetail moveStockBillDetail) {
        return ResponseEntity.ok(service.update(moveStockBillDetail));
    }

    @ApiOperation("删除移库单详情")
    @PreAuthorize("@ss.hasPermi('wms:moveStockBillDetail:remove')")
    @Log(title = "移库单详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Long[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
