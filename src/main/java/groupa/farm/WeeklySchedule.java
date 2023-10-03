package groupa.farm;

import groupa.animal.Horse;
import groupa.interfaces.Rider;
import groupa.person.Farmer;
import groupa.person.Person;
import groupa.person.Pilot;

// hardcoding Froilan and Froilanda for test purposes
public class WeeklySchedule {
    private Farm farm;
    private Farmer froilan;
    private Pilot froilanda;
    public WeeklySchedule(Farm farm, Farmer froilan, Pilot froilanda) {
        this.farm = farm;
        this.froilan = froilan;
        this.froilanda = froilanda;
    }

    public void sunday() {
        morningRoutine();


    }
    public void monday() {
        morningRoutine();
    }

    public void tuesday() {
        morningRoutine();
    }

    public void wednesday() {
        morningRoutine();
    }

    public void thursday() {
        morningRoutine();
    }

    public void friday() {
        morningRoutine();
    }

    public void saturday() {
        morningRoutine();
    }

    private void morningRoutine() {
        rideAllHorsesInEachStable();
        feedAllHorsesInEachStable();

        // food is hardcoded into Froilan's (The only Farmer) and Froilanda's (The only Pilot) eat methods
        froilan.eat();
        froilanda.eat();
    }

    private void rideAllHorsesInEachStable() {
        for (Stable stable : farm.getStables()) {
            if (stable.getHorses().size() == 1) {
                System.out.println("There is only one horse to ride, Froilan will ride it.");
                froilan.mount(stable.getHorses().get(0));
            } else {
                System.out.println("Stable " + farm.getStables().indexOf(stable));
                System.out.println("=============================");
                int counter = 0;
                int horseNumber = 0;
                for (Horse horse : stable.getHorses()) {
//                    if (froilan.isRiding()) {
//                        froilan.dismount(stable.getHorses().get(horseNumber));
//                        System.out.println("Froilan dismounted Horse " + horseNumber);
//                    }
//                    if (froilanda.isRiding()) {
//                        froilanda.dismount(stable.getHorses().get(horseNumber));
//                        System.out.println("Froilanda dismounted Horse " + horseNumber);
//                    }
                    checkIfRidingHorse(froilan, stable, horseNumber);
                    checkIfRidingHorse(froilanda, stable, horseNumber);
                    if (counter % 2 == 0 || counter == 0) {
                        froilan.mount(horse);
                        horseNumber = stable.getHorses().indexOf(horse);
                        System.out.println("Froilan is riding Horse " + horseNumber);
                    } else {
                        froilanda.mount(horse);
                        horseNumber = stable.getHorses().indexOf(horse);
                        System.out.println("Froilanda is riding Horse " + horseNumber);
                    }
                    counter++;
                }
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

    private void feedAllHorsesInEachStable() {
        for (Stable stable : farm.getStables()) {
            if (stable.getHorses().size() == 1) {
                System.out.println("There is only one horse to feed, Froilan will feed it.");
                froilan.mount(stable.getHorses().get(0));
            } else {
                System.out.println("Stable " + farm.getStables().indexOf(stable));
                System.out.println("=============================");
                int counter = 0;
                int horseNumber = 0;
                for (Horse horse : stable.getHorses()) {
//                    if (froilan.isRiding()) {
//                        froilan.dismount(stable.getHorses().get(horseNumber));
//                        System.out.println("Froilan dismounted Horse " + horseNumber);
//                    }
//                    if (froilanda.isRiding()) {
//                        froilanda.dismount(stable.getHorses().get(horseNumber));
//                        System.out.println("Froilanda dismounted Horse " + horseNumber);
//                    }
                    if (counter % 2 == 0 || counter == 0) {
                        horse.eat();
                        horseNumber = stable.getHorses().indexOf(horse);
                        System.out.println("Froilan fed Horse " + horseNumber);
                    } else {
                        horse.eat();
                        horseNumber = stable.getHorses().indexOf(horse);
                        System.out.println("Froilanda fed Horse " + horseNumber);
                    }
                    counter++;
                }
                System.out.println();
            }
        }
    }

}
