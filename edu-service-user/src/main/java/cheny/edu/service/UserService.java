package cheny.edu.service;


import cheny.edu.common.po.User;

import java.util.List;

/**
 * @author ChenYu
 */
public interface UserService {

    /**
     * 按ID查询用户信息
     *
     * @param id
     * @return
     */
    User selectUserById(String id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> selectAll();

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 更新用户
     *
     * @param user 用户对象
     * @return
     */
    int updateUser(User user);

    /**
     * 按ID删除
     *
     * @param id
     * @return
     */
    int deleteUserById(String id);
}
