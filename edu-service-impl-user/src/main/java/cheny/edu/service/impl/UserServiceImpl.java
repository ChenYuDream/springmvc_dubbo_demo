package cheny.edu.service.impl;

import cheny.edu.common.po.User;
import cheny.edu.common.utils.KeyUtil;
import cheny.edu.dao.UserDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import cheny.edu.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ChenYu
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User selectUserById(String id) {
        return userDao.selectUserById(id);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public int saveUser(User user) {
        if (StringUtils.isEmpty(user.getId())) {
            user.setId(KeyUtil.genUniqueKey());
        }
        return userDao.saveUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUserById(String id) {
        return userDao.deleteUserById(id);
    }
}
