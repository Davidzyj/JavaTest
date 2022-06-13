package cn.ruubypay.javatest.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 强制转换
        HttpServletRequest request = (HttpServletRequest)servletRequest;

        // 1. 获取资源请求路径
        String uri = request.getRequestURI();
        // 2.判断是否包含登录相关资源路径，需要注意排除掉css/js/图片/验证码等资源
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet")) {
            // 包含，证明用户就是要登录，放行
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            // 不包含，需要验证用户是否登录
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                //  用户已经登录，放行
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                // 没有登录，跳转登录页面
                request.setAttribute("login_msg", "您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
