package groupa.farm;

import groupa.person.Person;

import java.util.ArrayList;

public class FarmHouse {
    private ArrayList<Person> persons;

    public FarmHouse() {
        this.persons = new ArrayList<>();
    }

    /**
     *
     * @return ArrayList of Person
     */
    public ArrayList<Person> getPersons() {
        return persons;
    }

    /**
     * adds person object to ArrayList
     * @param person
     */
    public void addPerson(Person person) {
        persons.add(person);
    }
}
