package root.lesson_5;

import org.junit.Before;
import org.junit.Test;
import root.lesson_2.task_3.Person;
import root.lesson_2.task_3.Sex;

import static org.junit.Assert.*;

public class PetFilesTest {

    PetFiles pf = new PetFiles();

    Pet pet1 = new Pet("Mailo", new Person(24, Sex.WOMAN, "Mary"), 7.5f );
    Pet pet2 = new Pet("Sharik", new Person(30, Sex.MAN, "Sergey,"), 7.5f );
    Pet pet3 = new Pet("Alice", new Person(26, Sex.MAN, "Yegor"), 34.5f );
    //Животное с тем же хозяином
    Pet pet4 = new Pet("Markiz", new Person(26, Sex.MAN, "Yegor"), 8.3f );
    //Животное с тем же хозяином и кличкой
    Pet pet5 = new Pet("Alice", new Person(26, Sex.MAN, "Yegor"), 12.3f );
    //Полный дубликат
    Pet duplicatePet = new Pet("Alice", new Person(26, Sex.MAN, "Yegor"), 34.5f );

    Pet pet25 = new Pet("John", new Person(24, Sex.WOMAN, "Mary"), 5.5f );

    @Before
    public void init() throws DublicateException {
        pf.addPet(pet1);
        pf.addPet(pet2);
        pf.addPet(pet3);
        pf.addPet(pet4);
        pf.addPet(pet5);
    }

    @Test
    public void addPet() throws DublicateException {
        pf.printListOfPets();
        pf.addPet(duplicatePet);
        pf.printListOfPets();
    }

    @Test
    public void searchByName() {
        System.out.println(pf.searchByName("Markiz"));
    }

    @Test
    public void changingDataById() {
        System.out.println("Картотека до замены:");
        pf.printListOfPets();

        System.out.println("Картотека после замены:");
        pf.changingDataById(pet2.getId(), pet25);
        pf.printListOfPets();
    }

    @Test
    public void printListOfPets() {
        pf.printListOfPets();
    }
}