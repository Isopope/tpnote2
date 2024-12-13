package fr.univtours.polytech.tpnote2.controllers;

import java.io.IOException;

import fr.univtours.polytech.tpnote2.business.MovieBusiness;
import fr.univtours.polytech.tpnote2.models.MovieBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="increaseServlet", urlPatterns = {"/increaseNote"})
public class IncreaseServlet extends HttpServlet {
    @Inject
    private MovieBusiness movieBusiness;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer movieId = Integer.parseInt(request.getParameter("id"));
        MovieBean movie=movieBusiness.getMovieById(movieId);
        movieBusiness.increaseNote(movie.getId());
        response.sendRedirect("afficheMovie");
    }

}
