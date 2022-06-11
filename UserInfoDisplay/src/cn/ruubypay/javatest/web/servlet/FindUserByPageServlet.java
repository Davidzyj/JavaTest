package cn.ruubypay.javatest.web.servlet;

import cn.ruubypay.javatest.domain.PageBean;
import cn.ruubypay.javatest.domain.User;
import cn.ruubypay.javatest.server.UserService;
import cn.ruubypay.javatest.server.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 当前页码
        String currentPage = request.getParameter("currentPage");
        // 每页显示的数量
        String rows = request.getParameter("rows");

        // 下面这两个判断是当其他的servlet访问时的默认处理
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }


        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage, rows);

// 前端未完成后端调试技巧：访问host:8080/虚拟目录/findUserByPageServlet?currentPage=1&rows=5
//        System.out.println(pb);

        request.setAttribute("pb", pb);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
