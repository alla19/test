package by.tms.learnservlet.filter;

import by.tms.learnservlet.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "MainFilter", servletNames = {"RegServlet", "MainServlet"})
public class MainFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (currentUser.getName().equals("ADMIN")){
            chain.doFilter(req, res);
        } else res.sendRedirect("/main");
    }
}
