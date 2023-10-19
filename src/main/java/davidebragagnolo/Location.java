package davidebragagnolo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")

public class Location {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String city;

    public Location(String nome, String city) {
        super();
        this.nome = nome;
        this.city = city;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
