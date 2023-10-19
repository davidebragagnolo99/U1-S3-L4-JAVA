package davidebragagnolo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Concerto extends Evento {
    public enum GenereConcerto {
        CLASSICO, ROCK, POP
    }

    @Enumerated(EnumType.STRING)
    private GenereConcerto genere;
    private boolean inStreaming;

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipo, int numeroMassimoPartecipanti, Set<Partecipazione> partecipazioni, Location location, GenereConcerto genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipo, numeroMassimoPartecipanti, partecipazioni, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
