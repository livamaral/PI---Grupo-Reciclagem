package br.com.ecosenac.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import br.com.ecosenac.dao.PontoDao;
import br.com.ecosenac.model.Ponto;


@WebServlet("/create-ponto")
public class CreatePontoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pontoNome = request.getParameter("nome");
        String pontoEndereco = request.getParameter("endereco");
        String pontoCep = request.getParameter("cep");
        String pontoId = request.getParameter("pontoId");

        PontoDao pontoDao = new PontoDao();
        Ponto ponto = new Ponto(pontoNome, pontoEndereco, pontoCep);


        if (pontoId == null || pontoId.isBlank()) {
            pontoDao.createPonto(ponto);
        }

        response.sendRedirect("cadastro.html");
    }
}
