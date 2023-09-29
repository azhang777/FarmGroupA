package groupa.farm;

import groupa.person.Person;

import java.util.ArrayList;

public class FarmHouse {
    private ArrayList<Person> persons;

    public FarmHouse(ArrayList<Person> persons) {
        this.persons = new ArrayList<>();
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }
}
