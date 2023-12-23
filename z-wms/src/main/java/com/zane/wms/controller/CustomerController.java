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
import com.zane.wms.convert.CustomerConvert;
import com.zane.wms.domain.Customer;
import com.zane.wms.pojo.query.CustomerQuery;
import com.zane.wms.service.CustomerService;
import com.zane.wms.pojo.vo.CustomerVO;

/**
 * 客户Controller
 *
 * @author zane
 * @date 2023-12-23
 */
@Api(description ="客户接口列表")
@RestController
@RequestMapping("/wms/customer")
public class CustomerController extends BaseController {
    @Resource
    private CustomerService service;
    @Resource
    private CustomerConvert convert;

    @ApiOperation("查询客户列表")
    @PreAuthorize("@ss.hasPermi('wms:customer:list')")
    @PostMapping("/list")
    public ResponseEntity<Page<Customer>> list(@RequestBody CustomerQuery query, Pageable page) {
        List<Customer> list = service.selectList(query, page);
        return ResponseEntity.ok(new PageImpl<>(list, page, ((com.github.pagehelper.Page)list).getTotal()));
    }

    @ApiOperation("导出客户列表")
    @PreAuthorize("@ss.hasPermi('wms:customer:export')")
    @Log(title = "客户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public ResponseEntity<String> export(CustomerQuery query) {
        List<Customer> list = service.selectList(query, null);
        ExcelUtil<CustomerVO> util = new ExcelUtil<>(CustomerVO.class);
        return ResponseEntity.ok(util.writeExcel(convert.dos2vos(list), "客户数据"));
    }

    @ApiOperation("获取客户详细信息")
    @PreAuthorize("@ss.hasPermi('wms:customer:query')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getInfo(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.selectById(id));
    }

    @ApiOperation("新增客户")
    @PreAuthorize("@ss.hasPermi('wms:customer:add')")
    @Log(title = "客户", businessType = BusinessType.INSERT)
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.insert(customer));
    }

    @ApiOperation("修改客户")
    @PreAuthorize("@ss.hasPermi('wms:customer:edit')")
    @Log(title = "客户", businessType = BusinessType.UPDATE)
    @PutMapping
    public ResponseEntity<Integer> edit(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.update(customer));
    }

    @ApiOperation("删除客户")
    @PreAuthorize("@ss.hasPermi('wms:customer:remove')")
    @Log(title = "客户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public ResponseEntity<Integer> remove(@PathVariable Long[] ids) {
        return ResponseEntity.ok(service.deleteByIds(ids));
    }
}
