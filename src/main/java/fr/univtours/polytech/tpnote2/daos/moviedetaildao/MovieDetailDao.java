package fr.univtours.polytech.tpnote2.daos.moviedetaildao;

import java.util.List;

import fr.univtours.polytech.tpnote2.models.informations.Description;

public interface MovieDetailDao {

    public List<Description> getAllMovies(String movieTitle);

}
