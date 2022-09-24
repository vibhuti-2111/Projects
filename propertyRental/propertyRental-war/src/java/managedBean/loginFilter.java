/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package managedBean;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class loginFilter implements Filter {

    public static final String LOGIN_PAGE = "/client/login.xhtml";

    @Override
    public void doFilter(ServletRequest servletRequest,
            ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest =
        (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse
                = (HttpServletResponse) servletResponse;
        HttpSession userSession = httpServletRequest.getSession(false);

        

        if (userSession.getAttribute("userType") != null) {
            String userType = userSession.getAttribute("userType").toString();
            if (userType.equalsIgnoreCase("admin") || userType.equalsIgnoreCase("client") ||userType.equalsIgnoreCase("property owner")) {
                System.err.println("user is logged in Admin");
                // user is logged in, continue request
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                System.err.println("user is not logged in");
                // user is not logged in, redirect to login page
                httpServletResponse.sendRedirect(
                        httpServletRequest.getContextPath() + LOGIN_PAGE);
            }
        } else {
            System.err.println("userManager not found");
            // user is not logged in, redirect to login page
            httpServletResponse.sendRedirect(
                    httpServletRequest.getContextPath() + LOGIN_PAGE);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.err.println("loginFilter initialized");
    }

    @Override
    public void destroy() {
        // close resources
    }
}
