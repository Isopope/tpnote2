package fr.univtours.polytech.tpnote2.utils;

import java.io.IOException;

import fr.univtours.polytech.tpnote2.business.MovieBusiness;
import fr.univtours.polytech.tpnote2.models.MovieBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="fillDb", urlPatterns = {"/fillDb"})
public class FillDb extends HttpServlet {
    @Inject
    private MovieBusiness movieBusiness;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieBean bean1= new MovieBean();
        bean1.setNote(5);
        bean1.setTitle("seigneur des anneaux");
        movieBusiness.addMovie(bean1);
    }

}
