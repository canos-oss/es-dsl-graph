package cn.canos.esdslgraph;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
@WebListener
public class EsDslGraphListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("es-dsl-graph contextInitialized");

        FilterRegistration.Dynamic filterRegistration = sce.getServletContext().addFilter("esDslGraphFilter", EsDslGraphFilter.class);

        filterRegistration.addMappingForUrlPatterns(null, false, "/es-dsl-graph/*");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}