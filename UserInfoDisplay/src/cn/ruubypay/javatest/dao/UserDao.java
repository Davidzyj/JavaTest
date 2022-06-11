package cn.ruubypay.javatest.dao;

import cn.ruubypay.javatest.domain.User;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface UserDao {
    public List<User> findAll();
    User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void deleteUser(int parseInt);
}
