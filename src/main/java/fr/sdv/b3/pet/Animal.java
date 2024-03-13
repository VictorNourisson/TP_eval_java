package fr.sdv.b3.pet;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Animal")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "birth")
    protected LocalDate birth;
    @Column(name = "couleur")
    protected String couleur;
    @ManyToOne
    @JoinColumn(name="HOT_ID")
    protected PetStore petstore;

    public Animal(LocalDate birth, String couleur, PetStore petstore) {
        this.birth = birth;
        this.couleur = couleur;
        this.petstore = petstore;
    }

    public Animal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetstore() {
        return petstore;
    }

    public void setPetstore(PetStore petstore) {
        this.petstore = petstore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birth=" + birth +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}
