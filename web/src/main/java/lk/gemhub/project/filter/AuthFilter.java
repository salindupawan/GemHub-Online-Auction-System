package lk.gemhub.project.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@WebFilter(urlPatterns = {"/home", "/dashboard"})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        String uri = request.getRequestURI();

        if(session != null &&( session.getAttribute("user") != null )) {
            if(session.getAttribute("role").equals("admin") && uri.contains("/dashboard")) {
            filterChain.doFilter(request, response);

            }else if(session.getAttribute("role").equals("user") && uri.contains("/home")) {
                filterChain.doFilter(request, response);

            }else{
                response.sendRedirect("index.jsp");
            }
        }else{
            response.sendRedirect("login.jsp");
        }
    }
}
