package lk.gemhub.project.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lk.gemhub.project.model.User;
import lk.gemhub.project.remote.UserService;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @EJB
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //save request parameters to variables
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //authenticate user and assign user to a variable
        User user = userService.authenticateUser(email, password);

        if(user != null) {
            //save user to session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            Cookie cookie = new Cookie("email", user.getEmail());
            response.addCookie(cookie);

            if(user.getType().equals("admin")) {
                session.setAttribute("role", "admin");
                //redirect user to dashboard page
                response.sendRedirect("dashboard");
            }else if(user.getType().equals("user")) {
                session.setAttribute("role", "user");
                //redirect user to home page
                response.sendRedirect("home");
            }



        }else{
            //redirect user to login page
            response.sendRedirect("login.jsp");
        }

    }
}
