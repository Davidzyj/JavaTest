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

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    /**
     * 删除用户
     * @param id
     */
    @Override
    public void deleteUser(String id) {
        dao.deleteUser(Integer.parseInt(id));
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void delSelectedUsers(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                dao.deleteUser(Integer.parseInt(id));
            }
        }
    }
}
