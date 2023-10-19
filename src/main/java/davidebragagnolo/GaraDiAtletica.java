package davidebragagnolo;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
@NamedQuery(name = "getGareDiAtleticaPerVincitore", query = "SELECT g FROM Gara_Di_Atletica g WHERE g.vincitore = :vincitore")
@NamedQuery(name = "getGareDiAtleticaPerPartecipante", query = "SELECT g FROM Gara_Di_Atletica g WHERE g.setAtleti = :setAtleti")

public class GaraDiAtletica extends Evento{

    @OneToMany
    private Set<Persona> setAtleti;

    @OneToOne
    private Persona vincitore;

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipo,
                            int numeroMassimoPartecipanti, Location location, Set<Partecipazione> partecipazioni,
                            Set<Persona> setAtleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipo, numeroMassimoPartecipanti, partecipazioni, location);
        this.setAtleti = setAtleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getSetAtleti() {
        return setAtleti;
    }

    public void setSetAtleti(Set<Persona> setAtleti) {
        this.setAtleti = setAtleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
