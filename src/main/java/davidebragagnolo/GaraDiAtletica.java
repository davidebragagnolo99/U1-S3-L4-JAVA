package davidebragagnolo;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Set;
@Entity
public class GaraDiAtletica extends Evento{
    @ManyToMany
    private Set<Persona> atleti;
    @OneToOne
    private Persona vincitore;

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipo, int numeroMassimoPartecipanti, Set<Partecipazione> partecipazioni, Location location, Set<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipo, numeroMassimoPartecipanti, partecipazioni, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
