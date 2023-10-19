package davidebragagnolo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import davidebragagnolo.Persona;
import davidebragagnolo.Sesso;

import java.time.LocalDate;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona s) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(s);
        transaction.commit();
        System.out.println("Persona salvata correttamente!");
    }

    public Persona findById(int id) {
        Persona found = em.find(Persona.class, id);
        return found;
    }

    public void deleteById(int id) {
        Persona found = em.find(Persona.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("La persona è stata cancellata correttamente");
        } else {
            System.out.println("Errore");
        }
    }

    public void refresh(int id) {
        Persona found = em.find(Persona.class, id);
        if (found != null) {
            found.setNome("Pino");
            found.setCognome("La Lavatrice");
            found.setDataDiNascita(LocalDate.now());
            found.setEmail("pino.lalavatrice@email.it");
            found.setGenere(Sesso.MASCHIO);
            System.out.println("PRE REFRESH");
            System.out.println(found);
            em.refresh(found);
            System.out.println("POST REFRESH");
            System.out.println(found);
        } else {
            System.out.println("Nessuna persona trovata");
        }
    }

}
