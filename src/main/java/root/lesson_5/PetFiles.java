package root.lesson_5;

import java.util.*;

public class PetFiles {

    Set<Pet> pets = new HashSet<>();

    /**
     * Добавление животного в картотеку
     */
    public void addPet(Pet pet) throws DublicateException {
        if (pets.contains(pet)) {
            throw new DublicateException("Животное с такими данными уже существует");
        }
        pets.add(pet);
    }

    /**
     * Поиск животного по имени
     */
    public Pet searchByName(String name) {
        Pet pet = null;
        for (Pet p : pets) {
            if (p.getName().equals(name)) {
                pet = p;
            }
        }
        return pet;
    }

    /**
     * Изменение данных животного по его уникальному id
     */
    public void changingDataById(UUID id, Pet newPet) {
        for (Pet p : pets) {
            if (p.getId().equals(id)) {
                p.setName(newPet.getName());
                p.setOwner(newPet.getOwner());
                p.setWeight(newPet.getWeight());
            }
        }
    }

    /**
     * Вывод на экран списка по сортировке: хозяин, кличка, вес
     */
    public void printListOfPets() {
        List<Pet> arrayPets = new ArrayList<>(pets);
        Collections.sort(arrayPets);
        for (Pet p : pets) {
            System.out.println(p);
        }
    }

    @Override
    public String toString() {
        return "PetFiles{" +
                "pets=" + pets +
                '}';
    }
}
