package groupa.farm;

import groupa.Day;
import groupa.animal.Chicken;
import groupa.animal.Horse;
import groupa.interfaces.Rider;
import groupa.person.Farmer;
import groupa.person.Person;
import groupa.person.Pilot;

import java.util.ArrayList;

public class Farm {
    private ArrayList<Stable> stables;
    private ArrayList<ChickenCoop> chickenCoops;
    private FarmHouse farmHouse;
    private Field field;

    public Farm() {
        this.stables = new ArrayList<>();
        this.chickenCoops = new ArrayList<>();
        this.farmHouse = new FarmHouse();
        this.field = new Field();
    }

    public ArrayList<Stable> getStables() {
        return stables;
    }

    public ArrayList<ChickenCoop> getChickenCoops() {
        return chickenCoops;
    }

    public FarmHouse getFarmHouse() {
        return farmHouse;
    }

    public Field getField() {
        return field;
    }

    public void addStables(Stable stable) {
        this.stables.add(stable);
    }

    public void addChickenCoop(ChickenCoop chickenCoop) {
        this.chickenCoops.add(chickenCoop);
    }

    public void setFarmHouse(FarmHouse farmHouse) {
        this.farmHouse = farmHouse;
    }

    public void setField(Field field) {
        this.field = field;
    }
    // toStrings need to be Overrided for corresponding classes
    public void printFarm() {
        System.out.println(stables);
        System.out.println(chickenCoops);
        System.out.println(farmHouse);
    }

    public void advanceDay() {
        Day.nextDay();
    }

    public void rideAllHorsesInEachStable(Rider rider1, Rider rider2) {
        for (Stable stable : getStables()) {
            if (stable.getHorses().size() == 1) {
                System.out.println("There is only one horse to ride, " + ((Person)rider1).getName() + " will ride it.");
                rider1.mount(stable.getHorses().get(0));
            } else {
                System.out.println("Stable " + getStables().indexOf(stable));
                System.out.println("=============================");
                int counter = 0;
                int horseNumber = 0;
                for (Horse horse : stable.getHorses()) {
                    checkIfRidingHorse(rider1, stable, horseNumber);
                    checkIfRidingHorse(rider2, stable, horseNumber);
                    if (counter % 2 == 0 || counter == 0) {
                        rider1.mount(horse);
                        horseNumber = stable.getHorses().indexOf(horse);
                        System.out.println(((Person)rider1).getName() + " is riding Horse " + horseNumber);
                    } else {
                        rider2.mount(horse);
                        horseNumber = stable.getHorses().indexOf(horse);
                        System.out.println(((Person)rider2).getName() + " is riding Horse " + horseNumber);
                    }
                    counter++;
                }
                checkIfRidingHorse(rider1, stable, horseNumber);
                checkIfRidingHorse(rider2, stable, horseNumber);
                System.out.println();
            }
        }
    }
    private void checkIfRidingHorse(Rider rider, Stable stable, int horseNumber) {
        if (rider.isRiding()) {
            rider.dismount(stable.getHorses().get(horseNumber));
            System.out.println(((Person) rider).getName() + " dismounted Horse " + horseNumber);
        }
    }
    public void feedAllHorsesInEachStable(Person person1, Person person2) {
        for (Stable stable : getStables()) {
            if (stable.getHorses().size() == 1) {
                System.out.println("There is only one horse to feed, "+ person1.getName() + " will feed it.");
                stable.getHorses().get(0).eat();
            } else {
                System.out.println("Stable " + getStables().indexOf(stable));
                System.out.println("=============================");
                int counter = 0;
                int horseNumber = 0;
                for (Horse horse : stable.getHorses()) {
                    if (counter % 2 == 0 || counter == 0) {
                        horse.eat();
                        horseNumber = stable.getHorses().indexOf(horse);
                        System.out.println(person1.getName() + " fed Horse " + horseNumber);
                    } else {
                        horse.eat();
                        horseNumber = stable.getHorses().indexOf(horse);
                        System.out.println(person2.getName() + " fed Horse " + horseNumber);
                    }
                    counter++;
                }
                System.out.println();
            }
        }
    }
    public void feedAllChickensInEachChickenCoop() {
        for (ChickenCoop chickenCoop : getChickenCoops()) {
            for (Chicken chicken : chickenCoop.getChickens()) {
                chicken.eat();
                chicken.collectEgg();
            }
        }
    }
}
