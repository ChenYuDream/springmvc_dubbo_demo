package cheny.edu.dao;

import cheny.edu.common.po.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户dao
 *
 * @author
 * @create 2017-11-13 15:47
 **/
public interface UserDao {


    /**
     * 按ID查询用户信息
     *
     * @param id
     * @return
     */
    @Select("select * from eims_user where id=#{id}")
    User selectUserById(String id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Select("select * from eims_user")
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
