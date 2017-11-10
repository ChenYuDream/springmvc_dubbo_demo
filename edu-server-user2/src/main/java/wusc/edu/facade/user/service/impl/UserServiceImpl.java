package wusc.edu.facade.user.service.impl;

import org.springframework.stereotype.Service;
import wusc.edu.facade.user.service.UserService;

/**
 * @author ChenYu
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public int and(int x, int y) {

        return x + y + 10;
    }

    @Override
    public int sub(int x, int y) {
        return x - y;
    }
}
