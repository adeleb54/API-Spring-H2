package com.example.springbdd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pet {

    private static int idCounter = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String animal;
    private int age;

    /**
     * Définition du profil d'un animal
     * @param name nom de l'animal
     * @param animal espèce de l'animal
     * @param age âge (en années) de l'animal
     */
    public Pet(String name, String animal, int age) {
        this.id = idCounter++;
        this.name = name;
        this.animal = animal;
        this.age = age;
    }

    public Pet() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAnimal() {
        return animal;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
