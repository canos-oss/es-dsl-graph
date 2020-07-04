package cn.canos.esdslgraph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public final class MimeType {

    final static Map<String, String> MIMEMAP = new HashMap<String, String>();

    static {
        MIMEMAP.put("js", "text/javascript");
        MIMEMAP.put("png", "image/png");
        MIMEMAP.put("gif", "image/gif");
        MIMEMAP.put("css", "text/css");
        MIMEMAP.put("jpg", "image/jpeg");
        MIMEMAP.put("jpeg", "image/jpeg");
        MIMEMAP.put("html", "text/html;charset=utf-8");
    }

    public static String get(String extension) {

        return MIMEMAP.get(extension);
    }
}