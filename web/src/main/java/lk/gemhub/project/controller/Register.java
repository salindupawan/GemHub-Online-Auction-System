package lk.gemhub.project.controller;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.gemhub.project.dto.UserDTO;
import lk.gemhub.project.model.User;
import lk.gemhub.project.remote.UserService;
import lk.gemhub.project.repositary.UserRepo;
import lk.gemhub.project.validation.UserValidator;

import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    @EJB
    private UserService userService;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //save request parameters to variables
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        //create userDTO object
        UserDTO userDTO = new UserDTO(name, email, phone, password, confirmPassword,"user");

        //register user and redirect to home page
        if(userService.registerUser(userDTO)){
            response.sendRedirect("home.jsp");
        }

    }

}
