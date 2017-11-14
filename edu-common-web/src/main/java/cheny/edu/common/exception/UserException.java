package cheny.edu.common.exception;

import cheny.edu.common.enums.ResultStatusEnum;
import lombok.Getter;

/**
 * 用户异常类
 *
 * @author yu_chen
 * @create 2017-11-14 17:22
 **/
@Getter
public class UserException extends RuntimeException {

    private Integer code;

    /**
     * 直接传入结果状态枚举类的对象
     * @param resultStatusEnum
     */
    public UserException(ResultStatusEnum resultStatusEnum) {
        super(resultStatusEnum.getMsg());
        this.code = resultStatusEnum.getCode();
    }

    /**
     * @param code 状态值
     * @param message 信息
     */
    public UserException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
