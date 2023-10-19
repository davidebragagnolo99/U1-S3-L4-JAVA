package davidebragagnolo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "persona")


    public class Persona {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private Sesso genere;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private Set<Partecipazione> listaPartecipazioni;

    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Sesso genere, Set<Partecipazione> partecipazioni) {
        super();
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.genere = genere;
        this.listaPartecipazioni = partecipazioni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Sesso getGenere() {
        return genere;
    }

    public void setGenere(Sesso genere) {
        this.genere = genere;
    }

    public Set<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public void setListaPartecipazioni(Set<Partecipazione> listaPartecipazioni) {
        this.listaPartecipazioni = listaPartecipazioni;
    }
}
