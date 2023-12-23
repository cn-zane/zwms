package com.zane.framework.security.filter;

import com.zane.common.constant.Constants;
import com.zane.common.core.domain.model.LoginUser;
import com.zane.common.utils.SecurityUtils;
import com.zane.common.utils.StringUtils;
import com.zane.framework.web.service.TokenService;
import org.slf4j.MDC;
import javax.annotation.Resource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * token过滤器 验证token有效性
 *
 * @author zane
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private Lock lock = new ReentrantLock();
    @Resource
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser) && StringUtils.isNull(SecurityUtils.getAuthentication())) {
            tokenService.verifyToken(loginUser);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        boolean locked = false;
        try {
            locked = lock.tryLock(2, TimeUnit.MILLISECONDS);
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            MDC.put(Constants.SPAN_ID, uuid);
            response.addHeader(Constants.SPAN_ID, uuid);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
        chain.doFilter(request, response);
    }
}
