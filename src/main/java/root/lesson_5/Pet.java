package root.lesson_5;

import root.lesson_2.task_3.Person;

import java.util.Objects;
import java.util.UUID;

public class Pet implements Comparable<Pet> {

    private final UUID id;
    private String name;
    private Person owner;
    private float weight;

    public Pet(String name, Person owner, float weight) {
        id = UUID.randomUUID();
        this.name = name;
        this.owner = owner;
        this.weight = weight;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Pet o) {
        int res = this.owner.compareTo(o.owner);
        if (res == 0) {
            res = this.name.compareTo(o.name);
        }
        if (res == 0) {
            res = Float.compare(this.weight, o.weight);
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Float.compare(pet.weight, weight) == 0 &&
                Objects.equals(name, pet.name) &&
                Objects.equals(owner, pet.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, owner, weight);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", weight=" + weight +
                '}';
    }
}
