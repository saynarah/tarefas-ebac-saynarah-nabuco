package br.com.saynab.animals_service.controllers;

import br.com.saynab.animals_service.controllers.dtos.AnimalsRescuedByWorkerRespondeDTO;
import br.com.saynab.animals_service.controllers.dtos.CreateAnimalRequestDTO;
import br.com.saynab.animals_service.entities.Animal;
import br.com.saynab.animals_service.entities.AnimalType;
import br.com.saynab.animals_service.repositories.AnimalRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping
    private List<Animal> findAll() {
        return animalRepository.findAll();
    }

    @GetMapping("/{animalType}")
    private List<Animal> findAllbyType(@PathVariable("animalType") AnimalType animalType){
        return animalRepository.findAllByType(animalType);

    }

    @PostMapping
    private Animal create(@RequestBody CreateAnimalRequestDTO dto){

        Animal newAnimal = new Animal();
        newAnimal.setTemporaryName(dto.temporaryName());
        newAnimal.setEstimatedAge(dto.estimatedAge());
        newAnimal.setBreed(dto.breed());
        newAnimal.setDateEntry(dto.dateEntry());
        newAnimal.setDescriptionConditions(dto.descriptionConditions());
        newAnimal.setNameWorker(dto.nameWorker());
        newAnimal.setSize(dto.size());
        newAnimal.setAnimalType(dto.animalType());
        newAnimal.setAdoptionDate(dto.adoptionDate());
        return animalRepository.save(newAnimal);
    }

    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted(){
        return animalRepository.findNotAdopted();
    }

    @GetMapping("/adopted")
    private List<Animal> findAdopted(){
        return animalRepository.findAdopted();
    }

    @GetMapping("/not-adopted/{animalType}")
    private List<Animal> findNotAdoptedByType(@PathVariable("animalType") AnimalType animalType ){
        return animalRepository.findNotAdoptedByType(animalType);
    }

    @GetMapping("/adopted/{animalType}")
    private List<Animal> findAdoptedByType(@PathVariable("animalType") AnimalType animalType ){
        return animalRepository.findAdoptedByType(animalType);
    }

    @GetMapping("/workers")
    private List<AnimalsRescuedByWorkerRespondeDTO> findAnimalsRescuedByWorker(@RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                               @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        if (startDate.isBefore(endDate.minusYears(1))){
            throw new RuntimeException(new RuntimeException("The date difference is bigger than 1 year."));
        }

        return animalRepository.findAnimalsRescuedByWorker(startDate,endDate);
    }

}
