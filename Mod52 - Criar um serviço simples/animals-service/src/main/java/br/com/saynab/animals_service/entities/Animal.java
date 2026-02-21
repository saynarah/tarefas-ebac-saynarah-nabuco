package br.com.saynab.animals_service.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String temporaryName;

    @Column(nullable = false)
    private Integer estimatedAge;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private Date dateEntry;

    private Date adoptionDate;

    @Column(nullable = false)
    private String descriptionConditions;

    @Column(nullable = false)
    private String nameWorker;

    private Date deathDate;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private AnimalType animalType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public String getTemporaryName() {
        return temporaryName;
    }

    public void setTemporaryName(String temporaryName) {
        this.temporaryName = temporaryName;
    }

    public Integer getEstimatedAge() {
        return estimatedAge;
    }

    public void setEstimatedAge(Integer estimatedAge) {
        this.estimatedAge = estimatedAge;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(Date dateEntry) {
        this.dateEntry = dateEntry;
    }

    public Date getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(Date adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public String getDescriptionConditions() {
        return descriptionConditions;
    }

    public void setDescriptionConditions(String descriptionConditions) {
        this.descriptionConditions = descriptionConditions;
    }

    public String getNameWorker() {
        return nameWorker;
    }

    public void setNameWorker(String nameWorker) {
        this.nameWorker = nameWorker;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getSize() {
        return size;
    }

    @Enumerated(EnumType.STRING)
    public void setSize(String size) {
        this.size = size;
    }

}
