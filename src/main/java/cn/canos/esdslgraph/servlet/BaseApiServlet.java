package cn.canos.esdslgraph.servlet;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public abstract class BaseApiServlet extends HttpServlet {

    private final static Charset CHARSET = Charset.forName("UTF-8");
    private final static Gson GSON = new GsonBuilder().create();

    protected static <T> T parseRequest(HttpServletRequest request, Class<T> classOfT) throws IOException, IllegalAccessException, InstantiationException {

        //String defaultCharset = System.getProperty("sun.jnu.encoding");
        //Charset fileCharset = defaultCharset != null ? Charset.forName(defaultCharset) : Charset.defaultCharset();
        Scanner s = new Scanner(request.getInputStream(), CHARSET.name()).useDelimiter("\\A");
        String content = s.hasNext() ? s.next() : "";
        if (Strings.isNullOrEmpty(content)) {
            return classOfT.newInstance();
        }

        return GSON.fromJson(content, classOfT);
    }

    protected static void setResponse(HttpServletResponse response, Object item) throws IOException {

        response.setStatus(HttpServletResponse.SC_OK);

        if (item instanceof String) {
            response.setContentType("text/plain");
            response.getOutputStream().write(((String) item).getBytes(CHARSET));
            response.getOutputStream().close();
            return;
        }

        String content = GSON.toJson(item);
        response.setContentType("application/json;charset=UTF-8");
        response.getOutputStream().write(content.getBytes(CHARSET));
        response.getOutputStream().close();
    }

    protected static void setFileResponse(HttpServletResponse response, String fileName, String fileContent) throws IOException {

        response.setHeader("content-disposition", "attachment; filename=" + fileName);
        response.getOutputStream().write(fileContent.getBytes(CHARSET));
        response.getOutputStream().close();
    }
}