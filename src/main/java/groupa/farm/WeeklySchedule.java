package groupa.farm;

import groupa.Day;
import groupa.animal.Horse;
import groupa.crop.*;
import groupa.interfaces.Rider;
import groupa.person.Farmer;
import groupa.person.Person;
import groupa.person.Pilot;
import groupa.vehicle.CropDuster;
import groupa.vehicle.Tractor;

import java.util.Scanner;

// hardcoding Froilan and Froilanda for test purposes
public class WeeklySchedule {
    private Farm farm;
    private Farmer froilan;
    private Pilot froilanda;
    private Tractor tractor1;
    private CropDuster cropDuster;

    public WeeklySchedule(Farm farm, Farmer froilan, Pilot froilanda, Tractor tractor1, CropDuster cropDuster) {
        this.farm = farm;
        this.froilan = froilan;
        this.froilanda = froilanda;
        this.tractor1 = tractor1;
        this.cropDuster = cropDuster;
    }

    public void startWeek() {
        Scanner scanner = new Scanner(System.in);
        Day.setDay(0);
        runCurrentDay();
        while (true) {
            System.out.println("\nEnter 1 to advance day");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                farm.advanceDay();
                runCurrentDay();
            }
        }
    }

    private void runCurrentDay() {
        switch (Day.getCurrentDay()) {
            case 0:
                sunday();
                break;
            case 1:
                monday();
                break;
            case 2:
                tuesday();
                break;
            case 3:
                wednesday();
                break;
            case 4:
                thursday();
                break;
            case 5:
                friday();
                break;
            case 6:
                saturday();
                break;
        }
    }

    private void sunday() {
        System.out.println("\n SUNDAY:\n#######################");
        morningRoutine();
        froilan.plant(new CornStalk(), farm.getField().getCropRows().get(0));
        froilan.plant(new TomatoPlant(), farm.getField().getCropRows().get(1));
        froilan.plant(new TomatoPlant(), farm.getField().getCropRows().get(2));
        System.out.println("Items left int the basket: " + Basket.getInstance().totalAmount() + "\n");
    }

    private void monday() {
        System.out.println("\n MONDAY:\n#######################");
        morningRoutine();

        cropDuster.fly(farm.getField());
        froilanda.mount(cropDuster);
        cropDuster.fly(farm.getField());
        froilanda.dismount(cropDuster);
        System.out.println("By end of Monday, there are " + Basket.getInstance().totalAmount() + " items left int the basket: \n");
    }

    private void tuesday() {
        System.out.println("\n TUESDAY:\n#######################");
        morningRoutine();

        tractor1.harvest(farm.getField());
        froilan.mount(tractor1);
        tractor1.harvest(farm.getField());
        System.out.println("By end of Tuesday, there are " + Basket.getInstance().totalAmount() + " items left int the basket: \n");
    }

    private void wednesday() {
        System.out.println("\n WEDNESDAY:\n#######################");
        morningRoutine();
        for (int i = 0; i < 10; i++) {
            Crop crop = null;
            int random = (int) (Math.random() * 2);
            if (random == 0) {
                crop = new CornStalk();
            } else if (random == 1) {
                crop = new TomatoPlant();
            }
            froilan.plant(crop, farm.getField().getCropRows().get(0));
            froilan.plant(crop, farm.getField().getCropRows().get(1));
            froilan.plant(crop, farm.getField().getCropRows().get(2));
            froilan.plant(crop, farm.getField().getCropRows().get(3));
            froilan.plant(crop, farm.getField().getCropRows().get(4));
        }
    }

    private void thursday() {
        System.out.println("\n THURSDAY:\n#######################");
        morningRoutine();
    }

    private void friday() {
        System.out.println("\n FRIDAY:\n#######################");
        morningRoutine();
    }

    private void saturday() {
        System.out.println("\n SATURDAY:\n#######################");
        morningRoutine();
    }

    private void morningRoutine() {
        rideAllHorsesInEachStable();
        feedAllHorsesInEachStable();
        // food is hardcoded into Froilan's (The only Farmer) and Froilanda's (The only Pilot) eat methods
        froilan.eat();
        froilanda.eat();
        System.out.println("After morning routine, there are " + Basket.getInstance().totalAmount() + " items left int the basket: \n");
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
                checkIfRidingHorse(froilan, stable, horseNumber);
                checkIfRidingHorse(froilanda, stable, horseNumber);
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
                stable.getHorses().get(0).eat();
            } else {
                System.out.println("Stable " + farm.getStables().indexOf(stable));
                System.out.println("=============================");
                int counter = 0;
                int horseNumber = 0;
                for (Horse horse : stable.getHorses()) {
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
