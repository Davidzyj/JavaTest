package cn.ruubypay.javatest.server.impl;

import cn.ruubypay.javatest.dao.UserDao;
import cn.ruubypay.javatest.dao.impl.UserDaoImpl;
import cn.ruubypay.javatest.domain.PageBean;
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

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        // 下面这个判断用来解决当前端使用页面的<< 使页数小于1的时候的容错处理
        // 这个项目的实现方式是前端控制样式，后端控制逻辑 (个人感觉这个逻辑写在这里不太好，我感觉这个逻辑应该前置，也就是放在前端，这样可以减少请求的发送)
        if (currentPage <= 0) {
            currentPage = 1;
        }

        // 1. 创建一个空的PageBean
        PageBean<User> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        // 调用dao查询记录总数
        int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);

        // 调用dao查询list集合
        // 计算开始的索引
        int start = ( currentPage - 1 ) * rows;
        List<User> list = dao.findByPage(start, rows);
        pb.setList(list);

        // 计算总页码
        int totalPage = totalCount % rows == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
