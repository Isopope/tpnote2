package fr.univtours.polytech.tpnote2.daos;

import java.util.List;

import fr.univtours.polytech.tpnote2.models.MovieBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Stateless
public class MovieDaoImpl implements MovieDao{
    @PersistenceContext(unitName = "tp_note_2")
    private EntityManager em;

    @Override
    public List<MovieBean> getAllMovies() {

        Query req = em.createNativeQuery("SELECT * FROM movie", MovieBean.class);
        return req.getResultList();

    }

    @Override
    public MovieBean getMovieById(Integer id) {
        return em.find(MovieBean.class, id);
    }

    @Override
    public MovieBean updateMovie(MovieBean movieBean) {
        return em.merge(movieBean);
    }

    @Override
    public void addMovie(MovieBean movieBean) {
        if(movieBean.getNote()==null){
            movieBean.setNote(0);
        }
        em.persist(movieBean);
    }
    
    @Override
    public void deleteMovie(MovieBean movieBean) {
        em.remove(em.merge(movieBean));

    }

}
