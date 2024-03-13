package fr.sdv.b3.pet;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "label")
    private String label;
    @Column(name = "type")
    private ProdType type;
    @Column(name = "price")
    private Double price;
    @ManyToMany(mappedBy="products")
    private Set<PetStore> petsotres;

    public Product(Long id) {
        this.id = id;
    }

    public Product() {
    }

    public Product(String code, String label, ProdType type, Double price, Set<PetStore> petsotres) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
        this.petsotres = petsotres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<PetStore> getPetsotres() {
        return petsotres;
    }

    public void setPetsotres(Set<PetStore> petsotres) {
        this.petsotres = petsotres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", price=" + price +
                '}';
    }
}
