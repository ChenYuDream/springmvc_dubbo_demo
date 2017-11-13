package cheny.edu.dao;

import cheny.edu.common.pojo.User;
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
     * 查询所有用户信息
     *
     * @return
     */
    @Select("select * from user")
    List<User> selectAll();
}
