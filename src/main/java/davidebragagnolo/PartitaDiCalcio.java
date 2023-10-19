package davidebragagnolo;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT p FROM Partita_Di_Calcio p WHERE p.squadraVincente = :squadraVincente")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT p FROM Partita_Di_Calcio p WHERE p.ospite = :squadraVincente")
@NamedQuery(name = "getPartitePareggiate", query = "SELECT p FROM Partita_Di_Calcio p WHERE p.squadraVincente IS NULL")

public class PartitaDiCalcio extends Evento{

    private String squadraDiCasa;
    private String ospite;
    private String squadraVincente;
    private int nGoalHome;
    private int nGoalAway;

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipo,
                             int numeroMassimoPartecipanti, Location location, Set<Partecipazione> partecipazioni, String squadraDiCasa,
                             String ospite, String squadraVincente, int nGoalHome, int nGoalAway) {
        super(titolo, dataEvento, descrizione, tipo, numeroMassimoPartecipanti, partecipazioni, location);
        this.squadraDiCasa = squadraDiCasa;
        this.ospite = ospite;
        this.squadraVincente = squadraVincente;
        this.nGoalHome = nGoalHome;
        this.nGoalAway = nGoalAway;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getOspite() {
        return ospite;
    }

    public void setOspite(String ospite) {
        this.ospite = ospite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getnGoalHome() {
        return nGoalHome;
    }

    public void setnGoalHome(int nGoalHome) {
        this.nGoalHome = nGoalHome;
    }

    public int getnGoalAway() {
        return nGoalAway;
    }

    public void setnGoalAway(int nGoalAway) {
        this.nGoalAway = nGoalAway;
    }
}
