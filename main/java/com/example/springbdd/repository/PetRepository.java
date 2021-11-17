package com.example.springbdd.repository;

import com.example.springbdd.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Integer> {

    Iterable<Pet> findByName(String name);
    Pet findById(int id);
    void deleteById(int id);
}
