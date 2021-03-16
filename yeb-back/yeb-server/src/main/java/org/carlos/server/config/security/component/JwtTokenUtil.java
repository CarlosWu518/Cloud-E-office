package org.carlos.server.config.security.component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * @Description: JWT工具类
 * @Author: CarlosWu
 * @Date: 2021/3/13 20:38
 * @Version: 0.0.1
 */
@Component
public class JwtTokenUtil {
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /*
    * 根据用户信息生成token
    * */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }
    /*
    * 从token中获取登录名
    * */
    public String getUserNameFromToken(String token){
        String username;
        try {
            Claims claims = getClaimsFormToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
    /*
    * 从token中获取荷载
    * */
    private Claims getClaimsFormToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }
    /*
    * 验证token是否有效
    * */
    public boolean validateToken(String token,UserDetails userDetails){
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
    /*
    * 判断token是否可以被刷新
    * */
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }
    /*
    * 刷新token
    * */
    public String refreshToken(String token){
        Claims claims = getClaimsFormToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    /*
    *判断token是否失效
    * */
    private boolean isTokenExpired(String token) {
        Date expireDate = getExpiredDateFromToken(token);
        return expireDate.before(new Date());
    }
    /*
    * 从token中获取失效时间
    * */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFormToken(token);
        return claims.getExpiration();
    }


    /*
    * 根据荷载生成JWT TOKEN
    * */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /*
    * 生成token失效时间
    * */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

}
