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

        String userNome = request.getParameter("user-nome");

        String userEmail = request.getParameter("user-email");

        String userSenha = request.getParameter("user-senha");

        String userTelefone = request.getParameter("user-telefone");

        User user = new User(userNome, userEmail, userSenha, userTelefone);
        new UserDao().createUser(user);

        request.getRequestDispatcher("cadastro.html").forward(request, response);
    }

}