package com.dev;

import java.util.Random;
import java.util.Scanner;

public class MyLift {

    public static final int TOTAL_FLOORS = 10;
    public static final Scanner scan = new Scanner(System.in);

    private int liftCurrentFloor;
    private int personCurrentFloor;
    private int targetFloor;

    public static void main(String[] args) {
        MyLift myLift = new MyLift();
        myLift.startLiftOperation();
        scan.close();
    }

    public void startLiftOperation() {
        
        System.out.println("Starting lift operations...");
        
        liftCurrentFloor = new Random().nextInt(TOTAL_FLOORS);
        System.out.println("Lift is at floor: " + liftCurrentFloor);
        
        personCurrentFloor = takeInputAndValidate("Enter your current floor:");
        moveLift(liftCurrentFloor, personCurrentFloor); // Send lift to the person's floor.
        System.out.println("Lift has arrived to your floor, please get in...");

        targetFloor = takeInputAndValidate("Enter your target floor:");
        moveLift(personCurrentFloor, targetFloor); //Send the lift to target floor.
        System.out.println("Your destination is arrived, plesae get down...");
    }

    private int takeInputAndValidate(String inputMsg) {
        System.out.print(inputMsg);
        int inputFloor = scan.nextInt();
        boolean isValidInput = inputFloor >= 0 && inputFloor <= TOTAL_FLOORS;
        if (!isValidInput) {
            while (!isValidInput) {
                System.out.println("Invalid input, please enter again...");
                System.out.print(inputMsg);
                inputFloor = scan.nextInt();
                isValidInput = inputFloor >= 0 && inputFloor <= TOTAL_FLOORS;
            }
        }
        return inputFloor;
    }

    private void moveLift(int source, int dest) {
        while (source != dest) {
            if (source > dest) {
                source = source - 1;
                System.out.println("Sending lift down to floor: " + source);
            } else {
                source = source + 1;
                System.out.println("Sending lift UP to floor: " + source);
            }
        }

    }

}
