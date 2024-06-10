package com.cwnu.lease.web.admin.controller.login;


import com.cwnu.lease.common.result.Result;
import com.cwnu.lease.common.utils.JwtUtil;
import com.cwnu.lease.web.admin.service.LoginService;
import com.cwnu.lease.web.admin.vo.login.CaptchaVo;
import com.cwnu.lease.web.admin.vo.login.LoginVo;
import com.cwnu.lease.web.admin.vo.system.user.SystemUserInfoVo;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 后台管理系统登录相关的控制器。
 * 该控制器负责处理登录验证、获取验证码、以及登录用户信息的请求。
 *
 * @author Administrator
 */
@Tag(name = "后台管理系统登录管理")
@RestController
@RequestMapping("/admin")
public class LoginController {

    /**
     * 注入登录服务，用于处理登录相关的业务逻辑。
     */
    @Autowired
    private LoginService service;

    /**
     * 获取图形验证码。
     * 该接口用于在用户尝试登录时，提供图形验证码以验证用户身份。
     *
     * @return 返回图形验证码的相关信息。
     */
    @Operation(summary = "获取图形验证码")
    @GetMapping("login/captcha")
    public Result<CaptchaVo> getCaptcha() {
        CaptchaVo result = service.getCaptcha();
        return Result.ok(result);
    }

    /**
     * 用户登录。
     * 该接口用于处理用户的登录请求，验证用户身份并返回登录凭证（JWT）。
     *
     * @param loginVo 包含用户登录信息的请求体。
     * @return 返回登录成功后的JWT令牌。
     */
    @Operation(summary = "登录")
    @PostMapping("login")
    public Result<String> login(@RequestBody LoginVo loginVo) {
        String jwt = service.login(loginVo);
        return Result.ok(jwt);
    }

    /**
     * 获取登录用户个人信息。
     * 该接口用于在用户登录后，通过JWT令牌获取用户的个人信息。
     *
     * @param token 用户的JWT令牌，用于验证用户身份并获取用户信息。
     * @return 返回登录用户的个人信息。
     */
    @Operation(summary = "获取登陆用户个人信息")
    @GetMapping("info")
    public Result<SystemUserInfoVo> info(@RequestHeader("access-token") String token) {
        Claims claims = JwtUtil.parseToken(token);
        Long userId = claims.get("userId", Long.class);
        SystemUserInfoVo result = service.getLoginUserInfoById(userId);
        return Result.ok(result);
    }
}
