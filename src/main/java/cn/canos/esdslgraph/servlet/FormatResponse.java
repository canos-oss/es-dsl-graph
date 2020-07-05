package cn.canos.esdslgraph.servlet;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class FormatResponse {

    private Object content;

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

    /**
     * e.printStackTrace();
     */
    private String stackTrace;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

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

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}