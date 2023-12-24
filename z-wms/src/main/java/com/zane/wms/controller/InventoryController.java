package com.zane.wms.controller;

import java.util.List;

import com.zane.wms.pojo.dto.InventoryDTO;
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
import com.zane.wms.convert.InventoryConvert;
import com.zane.wms.domain.Inventory;
import com.zane.wms.pojo.query.InventoryQuery;
import com.zane.wms.service.InventoryService;
import com.zane.wms.pojo.vo.InventoryVO;

/**
 * 库存表Controller
 *
 * @author zane
 * @date 2023-12-24
 */
@Api(description ="库存表接口列表")
@RestController
@RequestMapping("/wms/inventory")
public class InventoryController extends BaseController {
    @Resource
    private InventoryService service;
    @Resource
    private InventoryConvert convert;

    @ApiOperation("查询库存表列表")
    @PreAuthorize("@ss.hasPermi('wms:inventory:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<InventoryDTO>> list(@RequestBody InventoryQuery query, Pageable page) {
        List<InventoryDTO> list = service.selectListDto(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出库存表列表")
    @PreAuthorize("@ss.hasPermi('wms:inventory:export')")
    @Log(title = "库存表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(InventoryQuery query) {
        List<Inventory> list = service.selectList(query, null);
        ExcelUtil<InventoryVO> util = new ExcelUtil<>(InventoryVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "库存表数据"));
    }

    @ApiOperation("获取库存表详细信息")
    @PreAuthorize("@ss.hasPermi('wms:inventory:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Inventory> getInfo(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增库存表")
    @PreAuthorize("@ss.hasPermi('wms:inventory:add')")
    @Log(title = "库存表", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(service.insert(inventory));
    }

    @ApiOperation("修改库存表")
    @PreAuthorize("@ss.hasPermi('wms:inventory:edit')")
    @Log(title = "库存表", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(service.update(inventory));
    }

    @ApiOperation("删除库存表")
    @PreAuthorize("@ss.hasPermi('wms:inventory:remove')")
    @Log(title = "库存表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Long[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
