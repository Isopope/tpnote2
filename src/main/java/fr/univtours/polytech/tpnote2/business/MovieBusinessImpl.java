package fr.univtours.polytech.tpnote2.business;

import java.util.List;

import fr.univtours.polytech.tpnote2.daos.MovieDao;
import fr.univtours.polytech.tpnote2.models.MovieBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
@Stateless
public class MovieBusinessImpl implements MovieBusiness{
    @Inject
    private MovieDao movieDao;

    @Override
    public List<MovieBean> getAllMovies() {
        return movieDao.getAllMovies();
    }

    @Override
    public MovieBean getMovieById(Integer id) {
        return movieDao.getMovieById(id);
    }

    @Override
    public MovieBean updateMovie(MovieBean movieBean) {
        return movieDao.updateMovie(movieBean);
    }

    @Override
    public void addMovie(MovieBean movieBean) {
        movieDao.addMovie(movieBean);
    }

    @Override
    public void deleteMovie(MovieBean movieBean) {
        movieDao.deleteMovie(movieBean);
    }

    @Override
    public void increaseNote(int movieId) {
        MovieBean movie=movieDao.getMovieById(movieId);
        if(movie!=null){
            Integer note=movie.getNote();
            if(note==0){
                movie.setNote(1);
            }else if(note<5){
                note=note+1;
                movie.setNote(note);
            }
            movieDao.updateMovie(movie);
        }
        
    }

    @Override
    public void decreaseNote(int movieId) {
        MovieBean movie=movieDao.getMovieById(movieId);
        if(movie!=null){
            Integer note=movie.getNote();
            if(note==0){
                movie.setNote(5);
            }else if(note>1){
                note=note-1;
                movie.setNote(note);
            }
            movieDao.updateMovie(movie);
        }
        
    }

}
