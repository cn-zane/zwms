package com.zane.framework.web.service;

import com.zane.common.constant.Constants;
import com.zane.common.constant.UserConstants;
import com.zane.common.core.domain.entity.SysUser;
import com.zane.common.core.domain.model.RegisterBody;
import com.zane.common.core.redis.RedisCache;
import com.zane.common.exception.user.CaptchaException;
import com.zane.common.exception.user.CaptchaExpireException;
import com.zane.common.utils.MessageUtils;
import com.zane.common.utils.SecurityUtils;
import com.zane.framework.manager.AsyncManager;
import com.zane.framework.manager.factory.AsyncFactory;
import com.zane.system.service.ISysConfigService;
import com.zane.system.service.ISysUserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 注册校验方法
 *
 * @author zane
 */
@Component
public class SysRegisterService
{
    @Resource
    private ISysUserService userService;

    @Resource
    private ISysConfigService configService;

    @Resource
    private RedisCache redisCache;

    /**
     * 注册
     */
    public String register(RegisterBody registerBody)
    {
        String msg = "", username = registerBody.getUsername(), password = registerBody.getPassword();

        boolean captchaOnOff = configService.selectCaptchaOnOff();
        // 验证码开关
        if (captchaOnOff)
        {
            validateCaptcha(username, registerBody.getCode(), registerBody.getUuid());
        }

        if (StringUtils.isEmpty(username))
        {
            msg = "用户名不能为空";
        }
        else if (StringUtils.isEmpty(password))
        {
            msg = "用户密码不能为空";
        }
        else if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            msg = "账户长度必须在2到20个字符之间";
        }
        else if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH)
        {
            msg = "密码长度必须在5到20个字符之间";
        } else if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(username))) {
            msg = "保存用户'" + username + "'失败，注册账号已存在";
        } else {
            try {
                register(username, "", "", registerBody.getPassword());
            } catch (Exception e) {
                msg = e.getMessage();
            }
        }
        return msg;
    }

    public SysUser register(String username, String nickname, String phone, String password) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);
        sysUser.setNickName(nickname);
        sysUser.setPhonenumber(phone);
        sysUser.setPassword(SecurityUtils.encryptPassword(password));
        boolean regFlag = userService.registerUser(sysUser);
        if (!regFlag) {
            throw new RuntimeException("注册失败,请联系系统管理人员");
        }
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.REGISTER,
                MessageUtils.message("user.register.success")));
        return sysUser;
    }

    /**
     * 校验验证码
     *
     * @param username 用户名
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public void validateCaptcha(String username, String code, String uuid)
    {
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null)
        {
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha))
        {
            throw new CaptchaException();
        }
    }
}
