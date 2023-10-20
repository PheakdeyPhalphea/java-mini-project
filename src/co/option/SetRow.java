package co.option;

import java.util.Scanner;

public class SetRow {
    static Scanner sc = new Scanner(System.in);
    public static int setRowFunction() {
        System.out.print("Please enter Row for Display : ");
        int userSetRow = (Integer.parseInt(sc.next()));
        System.out.println("~".repeat(15));
        System.out.println("Set Row to " + userSetRow + " Successfully. ");
        System.out.println("~".repeat(15));
        if (userSetRow <= 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
        }
        return userSetRow;
    }

}
