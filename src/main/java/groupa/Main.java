package groupa;

import groupa.animal.Chicken;
import groupa.animal.Horse;
import groupa.crop.*;
import groupa.farm.*;
import groupa.person.Farmer;
import groupa.person.Person;
import groupa.person.Pilot;
import groupa.vehicle.CropDuster;
import groupa.vehicle.Tractor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Farmer froilan = new Farmer("Froilan", "yeehaw", 30);
        Pilot froilanda = new Pilot("Froilanda", "mayday", 34);
        Farm farm = new Farm();
        Field field = new Field();
        CropRow row1 = new CropRow();
        CropRow row2 = new CropRow();
        field.addCropRow(row1);
        field.addCropRow(row2);
        field.addCropRow(new CropRow());
        field.addCropRow(new CropRow());
        field.addCropRow(new CropRow());
        farm.setField(field);

        for (int i = 0; i < 4; i++) {
            farm.addChickenCoop(new ChickenCoop());
        }
        for (int i = 0; i < farm.getChickenCoops().size() - 1; i++) {
            farm.getChickenCoops().get(i).addChicken(new Chicken("chicken", 1, false));
            farm.getChickenCoops().get(i).addChicken(new Chicken("chicken", 1, false));
            farm.getChickenCoops().get(i).addChicken(new Chicken("chicken", 1, false));
            farm.getChickenCoops().get(i).addChicken(new Chicken("chicken", 1, false));
        }
        farm.getChickenCoops().get(farm.getChickenCoops().size() - 1).addChicken(new Chicken("chicken", 1, false));
        farm.getChickenCoops().get(farm.getChickenCoops().size() - 1).addChicken(new Chicken("chicken", 1, false));
        farm.getChickenCoops().get(farm.getChickenCoops().size() - 1).addChicken(new Chicken("chicken", 1, false));

        for (int i = 0; i < 3; i++) {
            farm.addStables(new Stable());
        }
        for (int i = 0; i < farm.getStables().size() - 1; i++) {
            farm.getStables().get(i).addHorse(new Horse("horse", 3));
            farm.getStables().get(i).addHorse(new Horse("horse", 3));
            farm.getStables().get(i).addHorse(new Horse("horse", 3));
            farm.getStables().get(i).addHorse(new Horse("horse", 3));
        }
        farm.getStables().get(farm.getStables().size() - 1).addHorse(new Horse("horse",3));
        farm.getStables().get(farm.getStables().size() - 1).addHorse(new Horse("horse",3));

        FarmHouse farmHouse = new FarmHouse();
        farmHouse.addPerson(froilan);
        farmHouse.addPerson(froilanda);
        farm.setFarmHouse(farmHouse);

        Tractor tractor = new Tractor("VROOOOOOOOOOOOOO", 321);
        CropDuster cropDuster = new CropDuster("BZZZZZZZZZZZZZZZZZZZZZ", 123);
        System.out.println("Day:" + Day.getCurrentDay());

        // add crops to each crop row
        for (CropRow cropRow : field.getCropRows()) {
            cropRow.addCrop(new CornStalk());
            cropRow.addCrop(new CornStalk());
            cropRow.addCrop(new CornStalk());
            cropRow.addCrop(new CornStalk());
            cropRow.addCrop(new TomatoPlant());
            cropRow.addCrop(new TomatoPlant());
            cropRow.addCrop(new TomatoPlant());
            cropRow.addCrop(new TomatoPlant());
        }

        /*
        Set up Farm that has Farmer, Pilot, Field of 5 Crop Rows, 3 Stables of 10 Horses,
        4 ChickenCoops of 15 Chickens, 2 Farm Vehicles (tractors), 1 Aircraft (crop duster)
         */

        WeeklySchedule schedule = WeeklySchedule.getInstance(farm, froilan, froilanda, tractor, cropDuster);
        schedule.startWeek();
    }
}
