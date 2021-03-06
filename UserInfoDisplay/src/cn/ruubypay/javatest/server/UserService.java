package cn.ruubypay.javatest.server;

import cn.ruubypay.javatest.domain.PageBean;
import cn.ruubypay.javatest.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 登录方法
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 保存对象
     * @param user
     */
    void addUser(User user);

    void deleteUser(String id);

    User findUserById(String id);

    void updateUser(User user);

    void delSelectedUsers(String[] ids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
