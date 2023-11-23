package br.com.ecosenac.servlet;
import br.com.ecosenac.dao.PontoDao;
import br.com.ecosenac.model.Ponto;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/show-ponto")
public class ListPontoServlet extends HttpServlet {
    private static String id = "";

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        ListPontoServlet.id = id;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Ponto ponto = new PontoDao().exibirPonto(getId());

        System.out.println(ponto);

        req.setAttribute("ponto", ponto);

        req.getRequestDispatcher("Login-MeusDados.jsp").forward(req, resp);

    }
}
