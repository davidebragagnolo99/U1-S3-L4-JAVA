package davidebragagnolo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento s) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(s);
        transaction.commit();
        System.out.println("Evento salvato correttamente!");
    }

    public Evento findById(int id) {
    Evento found = em.find(Evento.class, id);
    return found;
    }

    public void deleteById(int id) {
        Evento found = em.find(Evento.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("L'evento è stato cancellato correttamente");
        } else {
            System.out.println("Errore");
        }
    }

    public void refresh(int evento) {
        em.refresh(evento);
    }

    //ANCORA NON TESTATE
    public List<Concerto> getConcertiInStreaming(){
        TypedQuery<Concerto> getAllQuery = em.createQuery("findByName", Concerto.class);
        return getAllQuery.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(Genere genere){
        TypedQuery<Concerto> query = em.createNamedQuery("findByName", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        TypedQuery<PartitaDiCalcio> query = em.createQuery("getPartiteVinteInCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        TypedQuery<PartitaDiCalcio> query = em.createQuery("getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartitePareggiate() {
        TypedQuery<PartitaDiCalcio> query = em.createQuery("getPartitePareggiate", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<GaraDiAtletica> getGareDiAtleticaPerVincitore(Persona persona){
        TypedQuery<GaraDiAtletica> query = em.createQuery("getGareDiAtleticaPerVincitore", GaraDiAtletica.class);
        return query.getResultList();
    }

    public List<GaraDiAtletica> getGareDiAtleticaPerPartecipante(Set<Persona> setAtleti){
        TypedQuery<GaraDiAtletica> query = em.createQuery("getGareDiAtleticaPerPartecipante", GaraDiAtletica.class);
        return query.getResultList();
    }

    public List<Evento> getEventiSoldOut(){
        TypedQuery<Evento> query = em.createQuery("getEventiSoldOut", Evento.class);
        return query.getResultList();
    }

    public List<Evento> getPartecipazioniDaConfermarePerEvento(Evento evento){
        TypedQuery<Evento> query = em.createQuery("getPartecipazioniDaConfermarePerEvento", Evento.class);
        return query.getResultList();
    }
}
