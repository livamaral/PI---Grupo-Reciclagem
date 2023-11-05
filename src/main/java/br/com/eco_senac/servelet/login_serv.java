package br.com.ecosenac.servelet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Cliente cliente = new Cliente(email, senha);

        boolean isValidUser = new ClienteDao().verifyCredentials(cliente);

        ListClienteServlet.setCliente(cliente);

        if (isValidUser) {

            req.getSession().setAttribute("loggedUser", email);

            resp.sendRedirect("show-cliente");

        } else {

            req.setAttribute("message", "Invalid credentials!");

            req.getRequestDispatcher("index.jsp").forward(req, resp);

        }

    }
}
