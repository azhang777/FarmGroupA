package groupa.farm;

import groupa.Day;
import groupa.crop.*;
import groupa.person.Farmer;
import groupa.person.Pilot;
import groupa.vehicle.CropDuster;
import groupa.vehicle.Tractor;

import java.util.Scanner;

public final class WeeklySchedule {
    /**
     * Singleton class
     */
    private static WeeklySchedule instance;
    private Farm farm;
    private Farmer farmer;
    private Pilot pilot;
    private Tractor tractor1;
    private CropDuster cropDuster;

    private WeeklySchedule(Farm farm, Farmer farmer, Pilot pilot, Tractor tractor1, CropDuster cropDuster) {
        this.farm = farm;
        this.farmer = farmer;
        this.pilot = pilot;
        this.tractor1 = tractor1;
        this.cropDuster = cropDuster;
    }
    public static WeeklySchedule getInstance(Farm farm, Farmer farmer, Pilot pilot, Tractor tractor1, CropDuster cropDuster) {
        if (instance == null) {
            instance = new WeeklySchedule(farm, farmer, pilot, tractor1, cropDuster);
        }
        return instance;
    }

    /**
     * start a scanner to advance each day after inputting 1
     */
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

    /**
     * Run a day method according to current day
     */
    private void runCurrentDay() {
        switch (Day.getCurrentDay()) {
            case 0 -> sunday();
            case 1 -> monday();
            case 2 -> tuesday();
            case 3 -> wednesday();
            case 4 -> thursday();
            case 5 -> friday();
            case 6 -> saturday();
        }
    }

    /**
     * start morning routine and plant crops
     */
    private void sunday() {
        System.out.println("\n SUNDAY:\n#######################");
        morningRoutine();
        plantMultipleCrops(farmer,1,0,70);
        plantMultipleCrops(farmer,2,1,50);
        plantMultipleCrops(farmer,2,2,25);
        plantMultipleCrops(farmer,1,2,80);
        System.out.println(farmer.getName() + " has planted on Sunday.");
        printBasketResultsByDay();
    }

    /**
     * start morning routine and fertilize field
     */
    private void monday() {
        System.out.println("\n MONDAY:\n#######################");
        morningRoutine();
        cropDuster.fly(farm.getField());
        pilot.mount(cropDuster);
        cropDuster.fly(farm.getField());
        pilot.dismount(cropDuster);
        printBasketResultsByDay();
    }

    /**
     * start morning routine and harvest field
     */
    private void tuesday() {
        System.out.println("\n TUESDAY:\n#######################");
        morningRoutine();

        tractor1.harvest(farm.getField());
        farmer.mount(tractor1);
        tractor1.harvest(farm.getField());
        farmer.dismount(tractor1);
        printBasketResultsByDay();
    }

    /**
     * plant CornStalk or TomatoPlant randomly, in each row after row 1 and row 2
     */
    private void wednesday() {
        System.out.println("\n WEDNESDAY:\n#######################");
        morningRoutine();
        for (int i = 2; i < farm.getField().getCropRows().size(); i++) {
            plantCropsByRandom(farmer,i,5);
        }
        printBasketResultsByDay();
    }

    /**
     * start morning routine and fertilize field
     */
    private void thursday() {
        System.out.println("\n THURSDAY:\n#######################");
        morningRoutine();
        pilot.mount(cropDuster);
        cropDuster.fly(farm.getField());
        pilot.dismount(cropDuster);
        printBasketResultsByDay();
    }

    /**
     * start morning routine and harvest field
     */
    private void friday() {
        System.out.println("\n FRIDAY:\n#######################");
        morningRoutine();
        farmer.mount(tractor1);
        tractor1.harvest(farm.getField());
        farmer.dismount(tractor1);
        printBasketResultsByDay();
    }

    /**
     * start morning routine and farmer and pilot relax for the day
     */
    private void saturday() {
        System.out.println("\n SATURDAY:\n#######################");
        morningRoutine();
        System.out.println(farmer.getName() + ": " + farmer.getFavPhrase());
        System.out.println(pilot.getName() + ": " + pilot.getFavPhrase());
        printBasketResultsByDay();
    }

    /**
     * ride all horses and feed all horses and chickens
     * farmer and pilot eat
     * print Basket results after, allows to see Basket results after every morning routine
     */
    private void morningRoutine() {
        farm.rideAllHorsesInEachStable(farmer, pilot);
        farm.feedAllHorsesInEachStable(farmer, pilot);
        farm.feedAllChickensInEachChickenCoop(farmer, pilot);
        // food is hardcoded into Froilan's (The only Farmer) and Froilanda's (The only Pilot) eat methods
        farmer.eat();
        pilot.eat();
        System.out.println("After morning routine, there are " + Basket.getInstance().totalAmount() + " items left int the basket: \n");
        System.out.println("Corn: " + Basket.getInstance().getCornAmount());
        System.out.println("Tomato: " + Basket.getInstance().getTomatoAmount());
        System.out.println("Eggs: " + Basket.getInstance().getEggAmount());
    }

    /**
     * print Basket results, meant to be called as the last method within each day method
     */
    private void printBasketResultsByDay() {
        System.out.println("\nBy the end of " + Day.returnDayAsString(Day.getCurrentDay())
        + ", there are " + Basket.getInstance().totalAmount() + " items left in the basket.");
        System.out.println("Corn: " + Basket.getInstance().getCornAmount());
        System.out.println("Tomato: " + Basket.getInstance().getTomatoAmount());
        System.out.println("Eggs: " + Basket.getInstance().getEggAmount());
    }

    private void plantMultipleCrops(Farmer farmer, int type, int rowNumber, int count) {
        Crop crop = null;

        for (int i = 0; i < count; i++) {
            if (type == 1) {
                crop = new CornStalk();
            } else if (type == 2) {
                crop = new TomatoPlant();
            }
            if(crop == null) {
                System.out.println("Type of crop not specified in plantMultipleCrops");
                System.out.println("1 = CornStalk, 2 = TomatoPlant");
                return;
            }
            farmer.plant(crop, farm.getField().getCropRows().get(rowNumber));
        }
    }

    private void plantCropsByRandom(Farmer farmer, int rowNumber, int count) {
        for (int j = 0; j < count; j++) {
            Crop crop = null;
            int random = (int) (Math.random() * 2);
            if (random == 0) {
                crop = new CornStalk();
            } else if (random == 1) {
                crop = new TomatoPlant();
            }
            farmer.plant(crop, farm.getField().getCropRows().get(rowNumber));
        }
    }
}
