package cn.canos.esdslgraph;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public abstract class ResponseBase {

    /**
     * 状态码
     * 0 - 失败
     * 1 - 成功
     * 其他 - 其他
     */
    private int statusCode;

    /**
     * 提示信息
     */
    private String message;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}