package fr.univtours.polytech.tpnote2.controllers;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.tpnote2.business.MovieBusiness;
import fr.univtours.polytech.tpnote2.models.MovieBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="afficheMovieServlet", urlPatterns = "/afficheMovie")
public class AfficheMovieServlet extends HttpServlet{
    @Inject
    private MovieBusiness movieBusiness;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<MovieBean> movies=movieBusiness.getAllMovies();
       request.setAttribute("MOVIES", movies);
        request.getRequestDispatcher("presentation/afficheMovies.jsp").forward(request, response);
    }

}
