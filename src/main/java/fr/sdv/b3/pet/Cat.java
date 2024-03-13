package fr.sdv.b3.pet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Cat")
public class Cat extends Animal{
    @Column(name = "chipld")
    private String chipld;

    public Cat(LocalDate birth, String couleur, PetStore petstore, String chipld) {
        super(birth, couleur, petstore);
        this.chipld = chipld;
    }

    public Cat() {
        super();
    }

    public String getChipld() {
        return chipld;
    }

    public void setChipld(String chipld) {
        this.chipld = chipld;
    }
}
