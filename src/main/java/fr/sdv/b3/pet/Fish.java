package fr.sdv.b3.pet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Fish")
public class Fish extends Animal {
    @Column(name = "livingEnv")
    private FishLivEnv livingEnv;

    public Fish() {
    }

    public Fish(LocalDate birth, String couleur, PetStore petstore, FishLivEnv livingEnv) {
        super(birth, couleur, petstore);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
