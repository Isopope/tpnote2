package fr.univtours.polytech.tpnote2.daos;

import java.util.List;

import fr.univtours.polytech.tpnote2.models.MovieBean;

public interface MovieDao {
    public List<MovieBean> getAllMovies();
    public MovieBean getMovieById(Integer id);
    public MovieBean updateMovie(MovieBean movieBean);
    public void addMovie(MovieBean movieBean);
    public void deleteMovie(MovieBean movieBean);

}
