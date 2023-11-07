package br.com.ecosenac.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import br.com.ecosenac.model.User;
import br.com.ecosenac.dao.UserDao;

@WebServlet("/create-ecosenac")
public class CreateEcoSenacServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usernome = request.getParameter("nome");
        String userEmail = request.getParameter("email");
        String userSenha = request.getParameter("senha");
        String userTelefone = request.getParameter("telefone");
        String userId = request.getParameter("userId");

        UserDao userDao = new UserDao();
        User user = new User(userId, usernome, userEmail, userSenha, userTelefone);


        if (userId == null || userId.isBlank()) {
            userDao.createUser(user);
        }

        response.sendRedirect("login.html");
    }
}
