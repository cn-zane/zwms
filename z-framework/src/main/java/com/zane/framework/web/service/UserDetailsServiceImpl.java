package com.zane.framework.web.service;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.zane.common.core.domain.entity.SysUser;
import com.zane.common.core.domain.model.LoginUser;
import com.zane.common.enums.UserStatus;
import com.zane.common.exception.ServiceException;
import com.zane.common.utils.StringUtils;
import com.zane.system.service.ISysUserService;

/**
 * 用户验证处理
 *
 * @author zane
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private ISysUserService userService;

    @Resource
    private SysPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.selectUserByUserName(username);
        if (StringUtils.isNull(user)) {
            log.warn("登录用户：{} 不存在", username);
            throw new ServiceException("登录用户：" + username + " 不存在");
        }
        if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
            log.warn("登录用户：{} 已被删除", username);
            throw new ServiceException("对不起，您的账号：" + username + " 已被删除");
        }
        if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            log.warn("登录用户：{} 已被停用", username);
            throw new ServiceException("对不起，您的账号：" + username + " 已停用");
        }

        return createLoginUser(user);
    }

    public UserDetails createLoginUser(SysUser user) {
        return new LoginUser(user.getUserId(), user.getDeptId(), user, permissionService.getMenuPermission(user));
    }
}
