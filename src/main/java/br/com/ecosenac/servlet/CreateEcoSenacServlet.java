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

        String userNome = request.getParameter("usernome");
        String userEmail = request.getParameter("useremail");
        String userSenha = request.getParameter("usersenha");
        String userTelefone = request.getParameter("usertelefone");
        String userId = request.getParameter("Id");

        UserDao userDao = new UserDao();
        User user = new User(userNome, userEmail, userSenha, userTelefone, userId);


        if (userId == null || userId.trim().isEmpty()) {
            userDao.createUser(user);
            ListClienteServlet.setId(user.getUserId());
        }

        response.sendRedirect("login.html");
    }
}
