package cn.canos.esdslgraph.servlet;

import cn.canos.esdslgraph.MimeType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class StaticResourceServlet extends HttpServlet {

    final static ConcurrentHashMap<String, byte[]> CONTENT_MAP = new ConcurrentHashMap<>();

    private static final String VISUAL_DIRECTORY = "/es-dsl-graph";
    private static final String VISUAL_DIRECTORY2 = "/es-dsl-graph/";
    private static final String LOCATION = "Location";
    private static final String STATIC = "/static";
    private static final int VISUAL_DIRECTORY_LENGTH = "/es-dsl-graph".length();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String servletPath = request.getServletPath();

        if (VISUAL_DIRECTORY.equalsIgnoreCase(servletPath)) {
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader(LOCATION, "es-dsl-graph/index.html");
            return;
        }
        if (VISUAL_DIRECTORY2.equalsIgnoreCase(servletPath)) {
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader(LOCATION, "index.html");
            return;
        }

        String extension = servletPath.substring(servletPath.lastIndexOf(".") + 1);
        String mimeType = MimeType.get(extension);

        byte[] bytes = CONTENT_MAP.get(servletPath);
        if (bytes != null) {
            setResponse(response, mimeType, bytes);
            return;
        }
        String path = STATIC + servletPath.substring(VISUAL_DIRECTORY_LENGTH);
        InputStream inputStream = StaticResourceServlet.class.getClassLoader().getResourceAsStream(path);
        if (inputStream != null) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(4096);
            byte[] buffer = new byte[4096];
            int length = 0;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            bytes = outputStream.toByteArray();
            CONTENT_MAP.putIfAbsent(servletPath, bytes);

            setResponse(response, mimeType, bytes);
            return;
        } else {
            //System.out.println("404   = " + path);
        }

        response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    private void setResponse(HttpServletResponse response, String mimeType, byte[] bytes) throws IOException {

        response.setContentType(mimeType);
        response.setStatus(HttpServletResponse.SC_OK);
        response.getOutputStream().write(bytes);
        response.getOutputStream().close();
    }
}