package cn.ruubypay.javatest.web.servlet;

import cn.ruubypay.javatest.domain.User;
import cn.ruubypay.javatest.server.UserService;
import cn.ruubypay.javatest.server.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 调用UserService完成查询
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();

        // 2. 将list存入request域
        request.setAttribute("users", users);

        // 3. 转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);

        System.out.println("122122112");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
