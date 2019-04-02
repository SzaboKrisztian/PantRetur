package dk.kea.stud.pantretur;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BottleDevourer machine = new BottleDevourer();
        Scanner scn = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Total is: " + machine.getRunningTotal() / 100.0);
            System.out.print("Insert a bottle ('DONE' to finish, 'DONATE' to donate: ");
            input = scn.nextLine();
            switch (input.toLowerCase()) {
                case "done":
                    machine.getReceipt();
                    break;
                case "donate":
                    machine.donate();
                    break;
                default:
                    if (machine.addBottle(input)) {
                        System.out.println("Bottle accepted.");
                    } else {
                        System.out.println("Bottle rejected.");
                    }
                    break;
            }
            System.out.println("\n");
        }
    }
}
