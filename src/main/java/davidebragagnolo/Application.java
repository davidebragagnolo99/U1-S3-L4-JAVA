package davidebragagnolo;

import utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.HashSet;

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

        pDAO.save(lines);
        pDAO.save(guido);
        lDAO.save(loc1);

        Partecipazione p1 = new Partecipazione(guido, pasto1, Stato.CONFERMATA);
        Partecipazione p2 = new Partecipazione(lines, pasto2, Stato.DA_CONFERMARE);
    }
}
