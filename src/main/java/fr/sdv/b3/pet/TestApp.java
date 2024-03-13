package fr.sdv.b3.pet;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class TestApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Address address = new Address();
        address.setNumber("12");
        address.setStreet("rue de la soif");
        address.setZipCode("88555");
        address.setCity("SH");
        em.persist(address);

        PetStore petStore = new PetStore();
        petStore.setName("Magasin");
        petStore.setManagerName("c'est moi");
        petStore.setAdresse(address);
        em.persist(petStore);

        Product product = new Product();
        product.setCode("OCDE");
        product.setLabel("Savon");
        product.setType(ProdType.CLEANING);
        product.setPrice(18.2);
        em.persist(product);

        Cat cat = new Cat();
        cat.setBirth(LocalDate.of(2007,4,9));
        cat.setCouleur("rouge");
        cat.setPetstore(petStore);
        em.persist(cat);

        Address address2 = new Address();
        address2.setNumber("10");
        address2.setStreet("rue de la");
        address2.setZipCode("44");
        address2.setCity("Nantes");
        em.persist(address2);

        PetStore petStore2 = new PetStore();
        petStore2.setName("Auchan");
        petStore2.setManagerName("test");
        petStore2.setAdresse(address2);
        em.persist(petStore2);

        Product product2 = new Product();
        product2.setCode("dfjeg5");
        product2.setLabel("ceci eug");
        product2.setType(ProdType.FOOD);
        product2.setPrice(11.2);
        em.persist(product2);

        Cat cat2 = new Cat();
        cat2.setBirth(LocalDate.of(2015,8,9));
        cat2.setCouleur("bleu");
        cat2.setPetstore(petStore2);
        cat2.setChipld("jsp");
        em.persist(cat2);

        Address address3 = new Address();
        address3.setNumber("20");
        address3.setStreet("rue de la vodka");
        address3.setZipCode("44700");
        address3.setCity("SSSB");
        em.persist(address3);

        PetStore petStore3 = new PetStore();
        petStore3.setName("Poudlard");
        petStore3.setManagerName("test5");
        petStore3.setAdresse(address3);
        em.persist(petStore3);

        Product product3 = new Product();
        product3.setCode("df");
        product3.setLabel("ceci");
        product3.setType(ProdType.FOOD);
        product3.setPrice(17.2);
        em.persist(product3);

        Fish fish = new Fish();
        fish.setBirth(LocalDate.of(2015,8,9));
        fish.setCouleur("bleu");
        fish.setPetstore(petStore2);
        fish.setLivingEnv(FishLivEnv.FRESH_WATER);
        em.persist(fish);

        TypedQuery<Animal> query = em.createQuery("select a from Animal a JOIN a.petstore p where p.id=1", Animal.class);
        List<Animal> animal = query.getResultList();
        System.out.println(animal);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
