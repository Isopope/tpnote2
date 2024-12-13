
package fr.univtours.polytech.tpnote2.daos.moviedetaildao;

import java.util.List;

import fr.univtours.polytech.tpnote2.models.informations.Description;
import fr.univtours.polytech.tpnote2.models.informations.WsInformationResult;
import jakarta.enterprise.concurrent.Asynchronous.Result;
import jakarta.validation.constraints.Future;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class MovieDetailDaoImpl implements MovieDetailDao{
    private  static String URL="https://imdb.iamidiotareyoutoo.com/search";

    @Override
    public List<Description> getAllMovies(String movieTitle) {
        // Instanciation du client.
    Client client = ClientBuilder.newClient();

    // On indique l'URL du Web Service.
    WebTarget target = client.target(URL);

    // On indique le "end point" (on aurait aussi pu directement le mettre dans
    // l'URL).
    // C'est également avec cette méthode qu'on pourrait ajouter des "path
    // parameters" si besoin.
    target = target.path("search");
    target = target.queryParam("q", movieTitle);

    // On appelle le WS en précisant le type de l'objet renvoyé, ici un
    // WsAddressResult.
    System.out.println(target.getUri());
    WsInformationResult wsResult = target.request(MediaType.APPLICATION_JSON).get(WsInformationResult.class);
    return wsResult.getDescription();    
        
    }

}
