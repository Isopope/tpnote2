package fr.univtours.polytech.tpnote2.business.rest;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
import java.util.List;

import fr.univtours.polytech.tpnote2.business.MovieBusiness;
import fr.univtours.polytech.tpnote2.models.MovieBean;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("v1")
public class MovieRest {
     @Inject
    private MovieBusiness movieBusiness;

    @GET
    @Path("movies")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<MovieBean> getMovies(
            @QueryParam("title") String title,
            @QueryParam("note") Integer note,
            @QueryParam("sort") String sort) {

        List<MovieBean> movies = this.movieBusiness.getAllMovies();
        List<MovieBean> results = new ArrayList<>(movies);

        // On commence par filtrer par titre
        if (title != null && !title.isEmpty()) {
            results.removeIf(movie -> !movie.getTitle().toLowerCase().contains(title.toLowerCase()));
        }

        // puis filtrer par note
        if (note != null) {
            results.removeIf(movie -> !movie.getNote().equals(note));
        }

        // On trie la liste sur la note
        if ("asc".equalsIgnoreCase(sort)) {
            results.sort((m1, m2) -> Integer.compare(m1.getNote(), m2.getNote()));
        } else if ("desc".equalsIgnoreCase(sort)) {
            results.sort((m1, m2) -> Integer.compare(m2.getNote(), m1.getNote()));
        }

        return results;
    }
    @POST
    @Path("movies")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addMovie(MovieBean movie){
        movieBusiness.addMovie(movie);
        return Response.status(Response.Status.OK).build();
  

    }

    @GET
    @Path("movies/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getMovieById(@PathParam("id") Integer idd) {
        MovieBean movie = movieBusiness.getMovieById(idd);
        if (movie == null) {
            // erreur 404 puisque le film n'existe pas
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Film avec l'ID " + idd + " non trouvé.")
                    .build();
        }
        return Response.status(Response.Status.OK)
                .entity(movie)
                .build();
    }

    @DELETE
    @Path("movies/{id}")
    public Response deleteMovie(@PathParam("id") Integer idd) {
        MovieBean movie = movieBusiness.getMovieById(idd);
        if (movie == null) {
            // erreur 404 puisque le film n'existe pas
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Film avec l'ID " + idd + " non trouvé.")
                    .build();
        }
        movieBusiness.deleteMovie(movie);
        return Response.status(Response.Status.OK).build();
  
    }



}
