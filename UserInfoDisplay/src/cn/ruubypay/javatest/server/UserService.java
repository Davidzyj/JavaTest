package cn.ruubypay.javatest.server;

import cn.ruubypay.javatest.domain.User;

import java.util.List;

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
}
