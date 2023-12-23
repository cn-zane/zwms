package com.fjp.lc.test.service;

import com.zane.ZWmsYiApplication;
import com.zane.common.utils.SecurityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = ZWmsYiApplication.class)
public class ServiceTest {

    /*
    * 加密密码 重置密码 默认密码 更改密码
    * */
    @Test
    public void encryptPassword() {
        String newPwd = "admin123";
        System.out.println("新密码："+SecurityUtils.encryptPassword(newPwd));
    }
}
