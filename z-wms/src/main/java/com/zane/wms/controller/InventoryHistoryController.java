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
import com.zane.wms.convert.InventoryHistoryConvert;
import com.zane.wms.domain.InventoryHistory;
import com.zane.wms.pojo.query.InventoryHistoryQuery;
import com.zane.wms.service.InventoryHistoryService;
import com.zane.wms.pojo.vo.InventoryHistoryVO;

/**
 * 库存记录Controller
 *
 * @author zane
 * @date 2023-12-25
 */
@Api(description ="库存记录接口列表")
@RestController
@RequestMapping("/wms/inventoryHistory")
public class InventoryHistoryController extends BaseController {
    @Resource
    private InventoryHistoryService service;
    @Resource
    private InventoryHistoryConvert convert;

    @ApiOperation("查询库存记录列表")
    @PreAuthorize("@ss.hasPermi('wms:inventoryHistory:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<InventoryHistory>> list(@RequestBody InventoryHistoryQuery query, Pageable page) {
        List<InventoryHistory> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出库存记录列表")
    @PreAuthorize("@ss.hasPermi('wms:inventoryHistory:export')")
    @Log(title = "库存记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(InventoryHistoryQuery query) {
        List<InventoryHistory> list = service.selectList(query, null);
        ExcelUtil<InventoryHistoryVO> util = new ExcelUtil<>(InventoryHistoryVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "库存记录数据"));
    }

    @ApiOperation("获取库存记录详细信息")
    @PreAuthorize("@ss.hasPermi('wms:inventoryHistory:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<InventoryHistory> getInfo(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增库存记录")
    @PreAuthorize("@ss.hasPermi('wms:inventoryHistory:add')")
    @Log(title = "库存记录", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody InventoryHistory inventoryHistory) {
        return ResponseEntity.ok(service.insert(inventoryHistory));
    }

    @ApiOperation("修改库存记录")
    @PreAuthorize("@ss.hasPermi('wms:inventoryHistory:edit')")
    @Log(title = "库存记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody InventoryHistory inventoryHistory) {
        return ResponseEntity.ok(service.update(inventoryHistory));
    }

    @ApiOperation("删除库存记录")
    @PreAuthorize("@ss.hasPermi('wms:inventoryHistory:remove')")
    @Log(title = "库存记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Long[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
