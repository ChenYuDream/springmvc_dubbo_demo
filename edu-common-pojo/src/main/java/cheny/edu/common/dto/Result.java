package cheny.edu.common.dto;


import cheny.edu.common.enums.ResultStatusEnum;
import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 结果集对象
 *
 * @author ChenYu
 */
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;

    private Boolean success;

    private String msg = "";

    private Object data = null;

    public Result() {
        this.code = 0;
        this.msg = "接口调用成功！";
    }

    /**
     * 直接传入object对象
     *
     * @param object
     */
    public Result(Object object) {
        if (object == null) {
            initResultStatus(ResultStatusEnum.FAILURE);
        } else if (object instanceof ResultStatusEnum) {
            initResultStatus((ResultStatusEnum) object);
        } else if (object instanceof List<?>) {
            this.code = ResultStatusEnum.SUCCESS.getCode();
            this.success = true;
            this.data = object;
        } else if (object instanceof Page) {
            this.code = ResultStatusEnum.SUCCESS.getCode();
            this.success = true;
            this.data = object;
        } else {
            this.code = ResultStatusEnum.SUCCESS.getCode();
            this.success = true;
            this.data = object;
        }
    }

    /**
     * @param code
     */
    public Result(int code) {
        this.code = code;
    }

    /**
     * @param success
     * @param msg
     */
    public Result(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    /**
     * 根据枚举对象初始化结果对象
     *
     * @param rs
     */
    private void initResultStatus(ResultStatusEnum rs) {
        this.code = rs.getCode();
        this.msg = rs.getMsg();
        this.success = rs.isSuccess();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
