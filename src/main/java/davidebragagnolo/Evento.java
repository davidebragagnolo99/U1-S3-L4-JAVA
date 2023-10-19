package davidebragagnolo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue
    private int Id;

    private String Titolo;
    private LocalDate DataEvento;
    private String Descrizione;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipo;
    private int numeroMassimoPartecipanti;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private Set<Partecipazione> partecipazioni;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Location location;

    public Evento () {}

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipo, int numeroMassimoPartecipanti, Set<Partecipazione> partecipazioni, Location location) {
        this.setTitolo(titolo);
        this.setDataEvento(dataEvento);
        this.setDescrizione(descrizione);
        this.setTipo(tipo);
        this.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
        this.setLocation(location);
        this.setPartecipazioni(partecipazioni);
    }

    public Set<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public Location getLocation() {
        return location;
    }

    public void setPartecipazioni(Set<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTitolo() {
        return Titolo;
    }

    public void setTitolo(String titolo) {
        Titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return DataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        DataEvento = dataEvento;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public int getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "Id=" + Id +
                ", Titolo='" + Titolo + '\'' +
                ", DataEvento=" + DataEvento +
                ", Descrizione='" + Descrizione + '\'' +
                ", tipo=" + tipo +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", partecipazioni=" + partecipazioni +
                ", location=" + location +
                '}';
    }
}
