package cheny.edu.service;


import cheny.edu.common.pojo.User;

import java.util.List;

/**
 * @author ChenYu
 */
public interface UserService {

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAll();
}
