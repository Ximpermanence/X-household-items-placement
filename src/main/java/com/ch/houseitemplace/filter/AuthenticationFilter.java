package com.ch.houseitemplace.filter;

import com.ch.houseitemplace.auth.RedisAuthenticationService;
import com.ch.houseitemplace.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {
/*    private final RedisAuthenticationService redisAuthenticationService;
    private final JwtUtil jwtUtil;
    private final RedisTemplate<String, Object> redisTemplate;

    public AuthenticationFilter(RedisAuthenticationService redisAuthenticationService, JwtUtil jwtUtil, RedisTemplate<String, Object> redisTemplate) {
        this.redisAuthenticationService = redisAuthenticationService;
        this.jwtUtil = jwtUtil;
        this.redisTemplate = redisTemplate;
    }*/

   /* @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        // 如果是登录请求，跳过这个过滤器
        if ("/login".equals(requestURI)) {
            filterChain.doFilter(request, response);  // 不做任何处理，直接交给下一个过滤器
            return;
        }

        String token = request.getHeader("Authorization");  // 获取 Authorization Header

        // 1. 请求头中没有携带 token
        if (StrUtil.isEmpty(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);  // 返回 401
            response.getWriter().write("Authentication is required");
            return;
        }

        String authorizationKey = extractAuthorizationKey(token);  // 提取授权 Key
        Authentication authentication = redisAuthenticationService.getAuthenticationFromRedis(authorizationKey);

        if (authentication != null && isTokenValid(authentication)) {
            SecurityContextHolder.getContext().setAuthentication(authentication);  // 设置当前用户的认证信息
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);  // 如果 token 无效，返回 401
            response.getWriter().write("Invalid token");
            return;
        }

        filterChain.doFilter(request, response);  // 继续执行过滤链
    }

    private String extractAuthorizationKey(String token) {
        // 提取 token，确保是合法的 Bearer token 格式
        if (token.startsWith("Bearer ")) {
            return token.replace("Bearer ", "");
        }
        return null;
    }

    private boolean isTokenValid(Authentication authentication) {
        // 添加 token 过期或有效性的判断逻辑（例如检查 JWT 过期时间）
        // 此处假设 token 有有效期逻辑，若有实际 token 检查可以补充
        return true;
    }*/
/*
    @Override
    protected void doFilterInternal(HttpServletRequest request, javax.servlet.http.HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);

            String username = jwtUtil.extractUsername(token);
            if (username != null && !jwtUtil.isTokenExpired(token)) {
                // 验证 Redis 中是否存在该 Token
                Object user = redisTemplate.opsForValue().get("USER:" + username + ":TOKEN");
                if (user != null && user.equals(token)) {
                    // 认证通过，设置认证信息
                    SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>()));
                } else {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token is invalid or expired");
                    return;
                }
            }
        }

        filterChain.doFilter(request, response);
    }*/

    @Autowired
    private RedisAuthenticationService redisService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            String userInfo = redisService.getUserInfo(token);

            if (userInfo != null) {
                // 验证token
                try {
                    String username = JwtUtil.getUsername(token);
                    SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, null, null));
                } catch (Exception e) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("Unauthorized");
                    return;
                }
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Unauthorized");
                return;
            }
        }else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized");
            return;
        }
        filterChain.doFilter(request, response);
    }
}

