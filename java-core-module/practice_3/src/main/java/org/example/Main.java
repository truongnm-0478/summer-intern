package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TransportManager manager = new TransportManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Vehicle Management System");
            System.out.println("1. Add a new vehicle");
            System.out.println("2. Search for a vehicle by vehicle number");
            System.out.println("3. Find vehicles by owner CMND number");
            System.out.println("4. Delete all vehicles of a manufacturer");
            System.out.println("5. Indicate the manufacturer with the most vehicles");
            System.out.println("6. Sort vehicles by vehicle number");
            System.out.println("7. Print statistics of each vehicle type");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manager.addNewVehicle(scanner);
                    break;
                case 2:
                    manager.searchVehicleByNumber(scanner);
                    break;
                case 3:
                    manager.findVehiclesByOwnerCmnd(scanner);
                    break;
                case 4:
                    manager.deleteVehiclesByManufacturer(scanner);
                    break;
                case 5:
                    manager.indicateManufacturerWithMostVehicles();
                    break;
                case 6:
                    manager.sortAndDisplayVehiclesByNumber();
                    break;
                case 7:
                    manager.printStatistics();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
    }
}
