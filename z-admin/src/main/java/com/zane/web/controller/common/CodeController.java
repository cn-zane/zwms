package com.zane.web.controller.common;

import com.zane.common.core.controller.BaseController;
import com.zane.common.core.domain.AjaxResult;
import com.zane.system.service.PhoneCodeService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/code")
public class CodeController extends BaseController {
    @Value("${zane.traceIdName}")
    private String traceIdName;
    @Resource
    private PhoneCodeService phoneCodeService;

    @GetMapping("/get")
    public AjaxResult getCode(HttpServletRequest request, @RequestParam String phone) {
        String uuid = request.getHeader(traceIdName);
        boolean res  = phoneCodeService.obtainCode(uuid, phone);
        return AjaxResult.success(res);
    }
}
