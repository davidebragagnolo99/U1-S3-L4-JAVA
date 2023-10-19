package davidebragagnolo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;

public class LocationDAO {
    private final EntityManager em;
    public LocationDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Location s) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(s);
        transaction.commit();
        System.out.println("Location salvata correttamente!");
    }
    public Location findById(int id) {
        Location found = em.find(Location.class, id);
        return found;
    }
    public void deleteById(int id) {
        Location found = em.find(Location.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("La location con id " + id + " è stata eliminata correttamente!" );
        }
    }
    public void refresh(int id) {
        Location found = em.find(Location.class, id);
        if (found != null) {
            found.setNome("Pino");
            found.setCity("Balocchi");
            found.setNome("Piazza degli asinelli");
            System.out.println("PRE REFRESH");
            System.out.println(found);
            em.refresh(found);
            System.out.println("POST REFRESH");
            System.out.println(found);
        } else {
            System.out.println("Nessuna location trovata");
        }
    }
}
