package cn.ruubypay.javatest.server.impl;

import cn.ruubypay.javatest.dao.UserDao;
import cn.ruubypay.javatest.dao.impl.UserDaoImpl;
import cn.ruubypay.javatest.domain.User;
import cn.ruubypay.javatest.server.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        // 调用Dao完成查询
        return dao.findAll();
    }
    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
