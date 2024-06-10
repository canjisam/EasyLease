package com.cwnu.lease.common.utils;


import com.cwnu.lease.common.exception.LeaseException;
import com.cwnu.lease.common.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
/**
 * JWT工具类，用于生成和解析JWT令牌。
 * @author jisam
 */
public class JwtUtil {

    /**
     * 令牌过期时间，单位为毫秒，默认为1小时。
     */
    private static long tokenExpiration = 60 * 60 * 1000L;

    /**
     * 用于令牌签名的密钥。
     */
    private static SecretKey tokenSignKey = Keys.hmacShaKeyFor("M0PKKI6pYGVWWfDZw90a0lTpGYX1d4AQ".getBytes());

    /**
     * 生成JWT令牌。
     *
     * @param userId 用户ID。
     * @param username 用户名。
     * @return 生成的JWT令牌字符串。
     */
    public static String createToken(Long userId, String username) {
        String token = Jwts.builder().
                setSubject("USER_INFO").
                setExpiration(new Date(System.currentTimeMillis() + tokenExpiration)).
                claim("userId", userId).
                claim("username", username).
                signWith(tokenSignKey).
                compressWith(CompressionCodecs.GZIP).
                compact();
        return token;
    }

    /**
     * 解析JWT令牌，并返回其中的声明。
     *
     * @param token JWT令牌字符串。
     * @return 解析出的声明。
     * @throws LeaseException 如果令牌过期或无效，则抛出异常。
     */
    public static Claims parseToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder().
                    setSigningKey(tokenSignKey).
                    build().parseClaimsJws(token);
            return claimsJws.getBody();

        } catch (ExpiredJwtException e) {
            throw new LeaseException(ResultCodeEnum.TOKEN_EXPIRED);
        } catch (JwtException e) {
            throw new LeaseException(ResultCodeEnum.TOKEN_INVALID);
        }
    }
    /**
     * 测试
     * */
    public static void main(String[] args) {
        System.out.println(createToken(1L, "zhangsan"));
    }
}
