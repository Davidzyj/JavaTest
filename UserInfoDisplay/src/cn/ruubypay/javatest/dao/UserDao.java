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

    User findById(int id);

    void updateUser(User user);

    /**
     * 查询总记录数
     * @return
     */
    int findTotalCount();

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @return
     */
    List<User> findByPage(int start, int rows);
}
