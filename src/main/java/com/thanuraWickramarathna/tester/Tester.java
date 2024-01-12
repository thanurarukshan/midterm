/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//22ug1-0529
package com.thanuraWickramarathna.tester;

/**
 *
 * @author thanu
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


import java.util.ArrayList;
import java.util.Scanner;
import java.time.Year;


/**
 *
 * @author thanu
 */

class BloodSugar {
    private int id;
    private String name;
    private int birthYear;
    private int sugarLevel;

    public BloodSugar(int id, String name, int birthYear, int sugarLevel) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.sugarLevel = sugarLevel;
//        int currentYear = Year.now().getValue();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
//        if (birthYear <= Year.now().getValue()) {
//            this.birthYear = birthYear;
        this.birthYear = birthYear;
//        }
//        else {
//            System.out.println("Invalid Year Entered");
//        }
    }

    public int getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(int sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public void calculate(int age,int sugarLevel) {
        //calculate function is not functional.
        if (age>0 && age<20) {
            //children
        }
        else if (age>=20 && age<65) {
            //adults
    }
        else {
            //seniors
        }
    }

    public void display() {
        System.out.println("ID: " + id + ",    Name: " + name + ",    Year of Birth: " + birthYear + ",    Sugar Level: " + sugarLevel);
    }
}


public class Tester {
    private static ArrayList<BloodSugar> records = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        while (true) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Options:");
            System.out.println("( 1 ) Create new record");
            System.out.println("( 2 ) Show blood sugar data ( all users )");
            System.out.println("( 3 ) Show blood sugar data ( selected user )");
            System.out.println("( 4 ) Delete all records");
            System.out.println("( 5 ) Exit");
            System.out.println("------------------------------------------------------------------------");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> {
                    create();
                    break;
                }
                case 2 -> {
                    index();
                    break;
                }
                case 3 -> {
                    System.out.println("Enter user ID:");
                    int userId = scanner.nextInt();
                    view(userId);
                    break;
                }
                case 4 -> {
                    delete();
                    break;
                }
                case 5 -> {
                    exit();
                    break;
                }
                default -> System.out.println("Error: Invalid pick. Try again");
            }

        }
    }

    public static void index() {
        System.out.println("Blood Sugar Data for All Users:");
        for (BloodSugar record : records) {
            record.display();
        }
    }

    public static void view(int id) {
        for (BloodSugar record : records) {
            if (record.getId() == id) {
                record.display();
                return;
            }
        }
        System.out.println("User with ID " + id + " not found.");
    }

    public static void create() {
        try {
            System.out.println("Enter user ID:");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter name:");
            String name = scanner.nextLine();

            System.out.println("Enter year of birth:");
            int birthYear = scanner.nextInt();
            if (birthYear >= Year.now().getValue()) {
                System.out.println("Invalid year entered, please refill the form !");
                create();
            }


            System.out.println("Enter blood sugar level:");
            int sugarLevel = scanner.nextInt();

            BloodSugar newRecord = new BloodSugar(id, name, birthYear, sugarLevel);
            records.add(newRecord);

            System.out.println("Record created successfully.");
        }
        catch (Exception e) {
            System.out.println("Unknown error occurred, please rerun the application!");
        }
    }

    public static void delete() {
        records.clear();
        System.out.println("All records deleted.");
    }

    public static void exit() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Exiting");
        System.out.println("------------------------------------------------------------------------");
        System.exit(0);
    }
}

