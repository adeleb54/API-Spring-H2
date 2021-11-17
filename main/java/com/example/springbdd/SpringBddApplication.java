package com.example.springbdd;

import com.example.springbdd.model.Pet;
import com.example.springbdd.repository.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBddApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBddApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBddApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PetRepository petRepository){
        return args -> {
            petRepository.save(new Pet("Malo", "Dog", 6));
            petRepository.save(new Pet("Pschiit", "Cat", 2));
            petRepository.save(new Pet("Pilou", "Cat", 2));

            log.info("Affichage de tous les potits animaux (findAll)");
            for(Pet p : petRepository.findAll()){
                log.info(p.toString());
            }

            log.info("Affichage d'un animal (findById)");
            log.info(petRepository.findById(1).toString());

            log.info("Affichage d'un animal (findByName)");
            log.info(petRepository.findByName("Pilou").toString());

            log.info("Ajout d'un animal (save)");
            petRepository.save(new Pet("Sora", "Dog", 10));
            for(Pet p : petRepository.findAll()){
                log.info(p.toString());
            }

            log.info("Suppression d'un animal (deleteById)");
            petRepository.deleteById(4);
            for(Pet p : petRepository.findAll()){
                log.info(p.toString());
            }


        };
    }

}
