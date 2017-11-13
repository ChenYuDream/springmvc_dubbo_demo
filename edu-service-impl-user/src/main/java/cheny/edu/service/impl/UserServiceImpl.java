package cheny.edu.service.impl;

import cheny.edu.common.pojo.User;
import cheny.edu.dao.UserDao;
import org.springframework.stereotype.Service;
import cheny.edu.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ChenYu
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }
}
