package cheny.edu.common.enums;

import java.util.Objects;

/**
 * 结果集的状态枚举类
 * @author ChenYu
 * @create 2017年11月14日17:13:35
 */
public enum ResultStatusEnum {
    /**
     * 成功
     */
    SUCCESS(0, "成功", true),
    /**
     * 失败
     */
    FAILURE(-1, "失败", false),;

    private int code;
    private String msg;
    private boolean success;

    /**
     * @param code
     * @param msg
     * @param success
     */
    ResultStatusEnum(int code, String msg, boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    // 根据code获取
    public static ResultStatusEnum getResultStatus(String code) {
        for (ResultStatusEnum r : ResultStatusEnum.values()) {
            if (Objects.equals(r.getCode(), code)) {
                return r;
            }
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
