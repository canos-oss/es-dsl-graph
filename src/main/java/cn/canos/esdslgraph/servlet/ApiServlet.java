package cn.canos.esdslgraph.servlet;

import cn.canos.esdslgraph.servlet.format.FormatServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class ApiServlet extends HttpServlet {

    private final static int PREFIX_LENGTH = "/es-dsl-graph/api".length();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalAccessException, InstantiationException, ServletException {

        String path = request.getServletPath().substring(PREFIX_LENGTH);

        switch (path.toLowerCase()) {
            case "/format": {
                FormatServlet.class.newInstance().service(request, response);
            }
            break;

            default: {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
            break;
        }
    }
}