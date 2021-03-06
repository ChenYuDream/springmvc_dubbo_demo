package cheny.edu.common.pojo;

import lombok.Data;

/**
 * 用户实体类
 *
 * @author yu_chen
 * @create 2017-11-13 15:39
 **/
@Data
public class User {

    /**
     * 主键ID
     */
    private String id;
    /**
     * 真实姓名
     */
    private String nickName;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 密码MD5值
     */
    private String passwordMd5;
    /**
     * email
     */
    private String email;
    /**
     * 电话号码
     */
    private String phoneNum;
}
