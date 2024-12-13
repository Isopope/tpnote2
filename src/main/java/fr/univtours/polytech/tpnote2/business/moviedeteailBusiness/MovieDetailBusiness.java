package fr.univtours.polytech.tpnote2.business.moviedeteailBusiness;

import java.util.List;

import fr.univtours.polytech.tpnote2.models.informations.Description;

public interface MovieDetailBusiness {

    public List<Description> getAllMovies(String movieTitle);

}
