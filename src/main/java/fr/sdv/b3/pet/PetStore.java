package fr.sdv.b3.pet;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PetStore")
public class PetStore {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "managerName")
    private String managerName;

    @ManyToMany
    @JoinTable(name="PET_PRO",
            joinColumns= @JoinColumn(name="ID_PET", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ID_PROD", referencedColumnName="ID")
    )
    private Set<Product> products;

    @OneToOne
    private Address adresse;

    public PetStore(Long id) {
        this.id = id;
    }

    public PetStore() {
    }

    public PetStore(String name, String managerName, Set<Product> products, Address adresse) {
        this.name = name;
        this.managerName = managerName;
        this.products = products;
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Address getAdresse() {
        return adresse;
    }

    public void setAdresse(Address adresse) {
        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetStore petStore = (PetStore) o;
        return Objects.equals(id, petStore.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                '}';
    }
}
