package com.cwnu.lease.web.admin.custom.interceptor;

import com.cwnu.lease.common.login.LoginUser;
import com.cwnu.lease.common.login.LoginUserHolder;
import com.cwnu.lease.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 认证拦截器，用于在请求处理之前进行认证检查。
 * 通过检查请求头中的access_token来判断请求是否合法。
 *
 * @author Jisam
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前进行拦截。
     * 检查请求头中是否包含access_token，并验证token的有效性。
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param handler  将要处理请求的目标对象
     * @return 如果认证通过，返回true，继续处理请求；否则，抛出异常，请求被拦截。
     * @throws Exception 如果token无效或为空，抛出LeaseException异常。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {

        // 从请求头中获取access_token
        String token = request.getHeader("access-token");

        Claims claims = JwtUtil.parseToken(token);
        Long userId = claims.get("userId", Long.class);
        String username = claims.get("username", String.class);
        LoginUserHolder.set(new LoginUser(userId, username));

        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginUserHolder.remove();
    }
}
