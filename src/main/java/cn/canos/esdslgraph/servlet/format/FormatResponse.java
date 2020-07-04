package cn.canos.esdslgraph.servlet.format;

import cn.canos.esdslgraph.servlet.ResponseBase;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class FormatResponse extends ResponseBase {

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}