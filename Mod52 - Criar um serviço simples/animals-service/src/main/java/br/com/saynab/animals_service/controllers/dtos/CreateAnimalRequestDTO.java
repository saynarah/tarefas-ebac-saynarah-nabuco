package br.com.saynab.animals_service.controllers.dtos;


import br.com.saynab.animals_service.entities.AnimalType;

import java.sql.Date;

public record CreateAnimalRequestDTO(
        String temporaryName,
        Integer estimatedAge,
        String breed,
        Date dateEntry,
        String descriptionConditions,
        String nameWorker,
        String size,
        AnimalType animalType,
        Date adoptionDate) {
}
