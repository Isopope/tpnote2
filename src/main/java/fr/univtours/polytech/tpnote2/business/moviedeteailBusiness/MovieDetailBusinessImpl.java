package fr.univtours.polytech.tpnote2.business.moviedeteailBusiness;

import java.util.List;

import fr.univtours.polytech.tpnote2.daos.moviedetaildao.MovieDetailDao;
import fr.univtours.polytech.tpnote2.models.informations.Description;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
@Stateless
public class MovieDetailBusinessImpl implements MovieDetailBusiness {
    @Inject
    private MovieDetailDao  movieDetailDao;

    @Override
    public List<Description> getAllMovies(String movieTitle) {
        return movieDetailDao.getAllMovies(movieTitle);
        
    }

}
