package groupa.farm;

import groupa.Day;
import groupa.crop.*;
import groupa.person.Farmer;
import groupa.person.Pilot;
import groupa.vehicle.CropDuster;
import groupa.vehicle.Tractor;

import java.util.Scanner;

public class WeeklySchedule {
    private Farm farm;
    private Farmer farmer;
    private Pilot pilot;
    private Tractor tractor1;
    private CropDuster cropDuster;

    public WeeklySchedule(Farm farm, Farmer farmer, Pilot pilot, Tractor tractor1, CropDuster cropDuster) {
        this.farm = farm;
        this.farmer = farmer;
        this.pilot = pilot;
        this.tractor1 = tractor1;
        this.cropDuster = cropDuster;
    }

    public void startWeek() {
        Scanner scanner = new Scanner(System.in);
        Day.setDay(0);
        runCurrentDay();
        while (true) {
            System.out.println("\n" + Day.returnDayAsString(Day.getCurrentDay()) +
                    " is finished. Enter 1 to advance into " +
                    Day.returnDayAsString(Day.getCurrentDay() + 1));
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
        farmer.plant(new CornStalk(), farm.getField().getCropRows().get(0));
        farmer.plant(new TomatoPlant(), farm.getField().getCropRows().get(1));
        farmer.plant(new TomatoPlant(), farm.getField().getCropRows().get(2));
        printBasketResultsByDay();
    }

    private void monday() {
        System.out.println("\n MONDAY:\n#######################");
        morningRoutine();
        for (int i = 0; i < 50; i++) {
            farmer.plant(new CornStalk(), farm.getField().getCropRows().get(0));
        }
        cropDuster.fly(farm.getField());
        pilot.mount(cropDuster);
        cropDuster.fly(farm.getField());
        pilot.dismount(cropDuster);
        printBasketResultsByDay();
    }

    private void tuesday() {
        System.out.println("\n TUESDAY:\n#######################");
        morningRoutine();

        tractor1.harvest(farm.getField());
        farmer.mount(tractor1);
        tractor1.harvest(farm.getField());
        for (int i = 0; i < 100; i++) {
            farmer.plant(new CornStalk(), farm.getField().getCropRows().get(0));
        }
        printBasketResultsByDay();
    }

    private void wednesday() {
        System.out.println("\n WEDNESDAY:\n#######################");
        morningRoutine();
        for (int i = 2; i < farm.getField().getCropRows().size(); i++) {
            CropRow cropRow = farm.getField().getCropRows().get(i);
            for (int j = 0; j < 30; j++) {
                Crop crop = null;
                int random = (int) (Math.random() * 2);
                if (random == 0) {
                    crop = new CornStalk();
                } else if (random == 1) {
                    crop = new TomatoPlant();
                }
                farmer.plant(crop, cropRow);
            }
        }
        pilot.mount(cropDuster);
        cropDuster.fly(farm.getField());
        pilot.dismount(cropDuster);
        printBasketResultsByDay();
    }

    private void thursday() {
        System.out.println("\n THURSDAY:\n#######################");
        morningRoutine();
        farmer.mount(tractor1);
        tractor1.harvest(farm.getField());
        farmer.dismount(tractor1);
        printBasketResultsByDay();
    }

    private void friday() {
        for (int i = 0; i < 100; i++) {
            farmer.plant(new CornStalk(), farm.getField().getCropRows().get(0));
        }
        System.out.println("\n FRIDAY:\n#######################");
        morningRoutine();
        printBasketResultsByDay();
    }

    private void saturday() {
        System.out.println("\n SATURDAY:\n#######################");
        morningRoutine();
        System.out.println(farmer.getName() + ": " + farmer.getFavPhrase());
        System.out.println(pilot.getName() + ": " + pilot.getFavPhrase());
        printBasketResultsByDay();
    }

    private void morningRoutine() {
        farm.rideAllHorsesInEachStable(farmer, pilot);
        farm.feedAllHorsesInEachStable(farmer, pilot);
        farm.feedAllChickensInEachChickenCoop();
        // food is hardcoded into Froilan's (The only Farmer) and Froilanda's (The only Pilot) eat methods
        farmer.eat();
        pilot.eat();
        System.out.println("After morning routine, there are " + Basket.getInstance().totalAmount() + " items left int the basket: \n");
        System.out.println("Corn: " + Basket.getInstance().getCornAmount());
        System.out.println("Tomato: " + Basket.getInstance().getTomatoAmount());
        System.out.println("Eggs: " + Basket.getInstance().getEggAmount());
    }





    private void printBasketResultsByDay() {
        System.out.println("\nBy the end of " + Day.returnDayAsString(Day.getCurrentDay())
        + ", there are " + Basket.getInstance().totalAmount() + " items left in the basket.");
        System.out.println("Corn: " + Basket.getInstance().getCornAmount());
        System.out.println("Tomato: " + Basket.getInstance().getTomatoAmount());
        System.out.println("Eggs: " + Basket.getInstance().getEggAmount());
    }

}
