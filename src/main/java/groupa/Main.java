package groupa;

import groupa.animal.Chicken;
import groupa.animal.Horse;
import groupa.crop.*;
import groupa.farm.*;
import groupa.person.Farmer;
import groupa.person.Person;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Person froilan = new Farmer("Froilan", "yeehaw", 30);
        Farm farm = new Farm();
        Field field = new Field();
        CropRow row1 = new CropRow();
        CropRow row2 = new CropRow();
        field.addCropRow(row1);
        field.addCropRow(row2);
        field.addCropRow(new CropRow());
        field.addCropRow(new CropRow());
        field.addCropRow(new CropRow());

        for (int i = 0; i < 4; i++) {
            farm.addChickenCoop(new ChickenCoop());
        }
        for (int i = 0; i < farm.getChickenCoops().size() - 1; i++) {
            farm.getChickenCoops().get(i).addChicken(new Chicken("chicken", 1, true));
            farm.getChickenCoops().get(i).addChicken(new Chicken("chicken", 1, true));
            farm.getChickenCoops().get(i).addChicken(new Chicken("chicken", 1, true));
            farm.getChickenCoops().get(i).addChicken(new Chicken("chicken", 1, true));
        }
        farm.getChickenCoops().get(farm.getChickenCoops().size() - 1).addChicken(new Chicken("chicken", 1, true));
        farm.getChickenCoops().get(farm.getChickenCoops().size() - 1).addChicken(new Chicken("chicken", 1, true));
        farm.getChickenCoops().get(farm.getChickenCoops().size() - 1).addChicken(new Chicken("chicken", 1, true));
    }
}
