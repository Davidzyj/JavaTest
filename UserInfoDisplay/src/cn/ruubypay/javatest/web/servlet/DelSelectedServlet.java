package cn.ruubypay.javatest.web.servlet;

import cn.ruubypay.javatest.domain.User;
import cn.ruubypay.javatest.server.UserService;
import cn.ruubypay.javatest.server.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取所有uid
        String[] ids = request.getParameterValues("uid");

        UserService service = new UserServiceImpl();
        service.delSelectedUsers(ids);

        response.sendRedirect(request.getContextPath() + "/userListServlet");


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
