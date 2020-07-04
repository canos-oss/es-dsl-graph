package cn.canos.esdslgraph;

import cn.canos.esdslgraph.servlet.StaticResourceServlet;
import cn.canos.esdslgraph.servlet.ApiServlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class EsDslGraphFilter implements Filter {

    private ApiServlet apiServlet;
    private StaticResourceServlet staticResourceServlet;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        apiServlet = new ApiServlet();
        apiServlet.init();
        staticResourceServlet = new StaticResourceServlet();
        staticResourceServlet.init();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String contextPath = httpRequest.getContextPath();
        String path = httpRequest.getRequestURI();

        if (!path.startsWith(contextPath + "/es-dsl-graph/") && !path.equalsIgnoreCase(contextPath + "/es-dsl-graph")) {
            chain.doFilter(request, response);
            return;
        }

        //api
        if (path.startsWith(contextPath + "/es-dsl-graph/api/")) {
            apiServlet.service(request, response);
            return;
        }

        staticResourceServlet.service(request, response);
    }

    @Override
    public void destroy() {
        apiServlet.destroy();
        apiServlet = null;
        staticResourceServlet.destroy();
        staticResourceServlet = null;
    }
}