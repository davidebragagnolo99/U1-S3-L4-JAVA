package davidebragagnolo;

import utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Application {

    private static EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO Ev = new EventoDAO(em);
        PersonaDAO pDAO = new PersonaDAO(em);
        LocationDAO lDAO = new LocationDAO(em);

        Persona guido = new Persona("Guido", "La Vespa", "guido.lavespa@email.it", LocalDate.now(), Sesso.MASCHIO, new HashSet<>());
        Persona lines = new Persona("Lines", "Ultra", "lines.ultra@email.it", LocalDate.now(), Sesso.FEMMINA, new HashSet<>());

        Location loc1 = new Location("Piazza degli asinelli", "Balocchi");

        Evento pasto1 = new Evento("Cena", LocalDate.now(), "Cena a scopo di lucro", TipoEvento.PUBBLICO, 50, loc1, new HashSet<>());
        Evento pasto2 = new Evento("Pranzo", LocalDate.now(), "Brunch", TipoEvento.PRIVATO, 30, loc1, new HashSet<>());
        Evento concerto1 = new Concerto("Queen", LocalDate.now(), "Concerto bello", TipoEvento.PUBBLICO, 50, loc1, new HashSet<>(), Genere.ROCK, false);
        Evento partita1 = new PartitaDiCalcio("Derby", LocalDate.now(), "Derby Roma - Lazio", TipoEvento.PUBBLICO, 80000, loc1,  new HashSet<>(), "Roma", "Lazio", "Roma", 1, 1);
        Evento partita2 = new PartitaDiCalcio("Derby", LocalDate.now(), "Derby Roma - Lazio", TipoEvento.PUBBLICO, 80000, loc1,  new HashSet<>(), "Roma", "Lazio", "Roma", 1, 1);
        Evento partita3 = new PartitaDiCalcio("Derby", LocalDate.now(), "Derby Roma - Lazio", TipoEvento.PUBBLICO, 80000, loc1,  new HashSet<>(), "Roma", "Lazio", "Roma", 1, 1);
        Evento gara1 = new GaraDiAtletica("Nazionali Calisthenics", LocalDate.now(), "Finali di Calisthenics", TipoEvento.PUBBLICO, 100, loc1,  new HashSet<>(), new HashSet<>(), guido);

        // pDAO.save(lines);
        // pDAO.save(guido);
        // lDAO.save(loc1);

        Partecipazione p1 = new Partecipazione(guido, pasto1, Stato.CONFERMATA);
        Partecipazione p2 = new Partecipazione(lines, pasto2, Stato.DA_CONFERMARE);

        Set<Partecipazione> lp1 = new HashSet<>();

        em.getTransaction().begin();
        em.getTransaction().commit();

        Ev.refresh(4);
        em.close();

        emf.close();
    }
}
