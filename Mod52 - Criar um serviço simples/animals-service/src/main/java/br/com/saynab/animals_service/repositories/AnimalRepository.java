package br.com.saynab.animals_service.repositories;

import br.com.saynab.animals_service.controllers.dtos.AnimalsRescuedByWorkerRespondeDTO;
import br.com.saynab.animals_service.entities.Animal;
import br.com.saynab.animals_service.entities.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface AnimalRepository extends JpaRepository<Animal,Integer> {

    @Query("SELECT a FROM Animal a WHERE a.animalType = :animalType")
    List<Animal> findAllByType(AnimalType animalType);

    @Query("SELECT a FROM Animal a WHERE a.adoptionDate IS NULL ORDER BY a.dateEntry DESC")
    List<Animal> findNotAdopted();

    @Query("SELECT a FROM Animal a WHERE a.adoptionDate IS NOT NULL ORDER BY a.dateEntry DESC")
    List<Animal> findAdopted();

    @Query("SELECT a FROM Animal a WHERE a.adoptionDate IS NULL AND a.animalType = :animalType ORDER BY a.dateEntry DESC")
    List<Animal> findNotAdoptedByType(AnimalType animalType);

    @Query("SELECT a FROM Animal a WHERE a.adoptionDate IS NOT NULL AND a.animalType = :animalType ORDER BY a.dateEntry DESC")
    List<Animal> findAdoptedByType(AnimalType animalType);


    @Query("SELECT a.nameWorker, COUNT(a.id) FROM Animal a WHERE a.dateEntry BETWEEN :startDate AND :endDate GROUP BY a.nameWorker")
    List<AnimalsRescuedByWorkerRespondeDTO> findAnimalsRescuedByWorker(LocalDate startDate, LocalDate endDate);
}
