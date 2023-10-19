package davidebragagnolo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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

    public void refresh(Evento evento) {
        em.refresh(evento);
    }
}
