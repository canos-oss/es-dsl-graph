package cn.canos.esdslgraph.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author harriszhang@live.cn
 */
@WebServlet(urlPatterns = "/es-dsl-graph/*")
public class StaticResourceServlet extends HttpServlet {

    final static ConcurrentHashMap<String, byte[]> CONTENT_MAP = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String dispatcherPath = requestURI.substring(contextPath.length());

        if ("/es-dsl-graph".equalsIgnoreCase(dispatcherPath)) {
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "es-dsl-graph/index.html");
            return;
        }
        if ("/es-dsl-graph/".equalsIgnoreCase(dispatcherPath)) {
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "index.html");
            return;
        }

        String extension = dispatcherPath.substring(dispatcherPath.lastIndexOf(".") + 1);
        String mimeType = MimeType.get(extension);

        byte[] bytes = CONTENT_MAP.get(dispatcherPath);
        if (bytes != null) {
            setResponse(response, mimeType, bytes);
            return;
        }
        String path = "/static" + dispatcherPath.substring("/es-dsl-graph".length());

        InputStream inputStream = this.getClass().getResourceAsStream(path);
        if (inputStream != null) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(4096);
            byte[] buffer = new byte[4096];
            int length = 0;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            bytes = outputStream.toByteArray();
            CONTENT_MAP.putIfAbsent(dispatcherPath, bytes);

            setResponse(response, mimeType, bytes);
            return;
        } else {
            System.out.println("404 NOT Found  = " + path);
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