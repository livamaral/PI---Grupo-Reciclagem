package br.com.ecosenac.servlet;

import br.com.ecosenac.dao.UserDao;
import br.com.ecosenac.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/show-cliente")
public class ListClienteServlet extends HttpServlet {
    private static String id = "";

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        ListClienteServlet.id = id;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User cliente = new UserDao().exibirUser(getId());

        System.out.println(cliente);

        req.setAttribute("cliente", cliente);

        req.getRequestDispatcher("Login-MeusDados.jsp").forward(req, resp);

    }
}
