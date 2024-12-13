package fr.univtours.polytech.tpnote2.business;

import java.util.List;

import fr.univtours.polytech.tpnote2.models.MovieBean;

public interface MovieBusiness {
    public List<MovieBean> getAllMovies();
    public MovieBean getMovieById(Integer id);
    public MovieBean updateMovie(MovieBean movieBean);
    public void addMovie(MovieBean movieBean);
    public void deleteMovie(MovieBean movieBean);
    public void increaseNote(int movieId);
    public void decreaseNote(int movieId);

}
