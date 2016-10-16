package org.dukecon;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author Falk Sippach, falk@jug-da.de, @sippsack
 */
@Component
public class UrlSchemaFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("called filter");
        servletResponse.getWriter().write("<html>");
        servletResponse.getWriter().write("<body>");
        servletResponse.getWriter().write(request.getRequestURL().toString() + "<br/>");
        servletResponse.getWriter().write("request parameter: " + request.getQueryString() + "<br/>");
        servletResponse.getWriter().write("Header: " + "<br/>");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            servletResponse.getWriter().write(key + ": " + value + "<br/>");
        }
        servletResponse.getWriter().write("</body>");
        servletResponse.getWriter().write("</html>");
    }

    @Override
    public void destroy() {

    }
}
