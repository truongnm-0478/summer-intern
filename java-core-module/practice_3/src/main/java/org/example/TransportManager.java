package org.example;
import java.util.*;

public class TransportManager {
    private List<Vehicle> vehicles;

    public TransportManager() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Vehicle searchVehicleByNumber(String vehicleNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleNumber().equals(vehicleNumber)) {
                return vehicle;
            }
        }
        return null;
    }

    public List<Vehicle> findVehiclesByOwnerCmnd(String cmnd) {
        List<Vehicle> ownerVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getOwner().getCmnd().equals(cmnd)) {
                ownerVehicles.add(vehicle);
            }
        }
        return ownerVehicles;
    }

    public void deleteVehiclesByManufacturer(String manufacturer) {
        vehicles.removeIf(vehicle -> vehicle.getManufacturer().equals(manufacturer));
    }

    public String getManufacturerWithMostVehicles() {
        Map<String, Integer> manufacturerCount = new HashMap<>();

        for (Vehicle vehicle : vehicles) {
            String manufacturer = vehicle.getManufacturer();
            manufacturerCount.put(manufacturer, manufacturerCount.getOrDefault(manufacturer, 0) + 1);
        }

        String mostCommonManufacturer = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : manufacturerCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonManufacturer = entry.getKey();
            }
        }

        return mostCommonManufacturer;
    }

    public void sortVehiclesByNumber() {
        Collections.sort(vehicles, Comparator.comparing(Vehicle::getVehicleNumber));
    }

    public void printStatistics() {
        int carCount = 0;
        int motorcycleCount = 0;
        int truckCount = 0;

        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                carCount++;
            } else if (vehicle instanceof Motorcycle) {
                motorcycleCount++;
            } else if (vehicle instanceof Truck) {
                truckCount++;
            }
        }

        System.out.println("Vehicle Statistics:");
        System.out.println("Cars: " + carCount);
        System.out.println("Motorcycles: " + motorcycleCount);
        System.out.println("Trucks: " + truckCount);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addNewVehicle(Scanner scanner) {
        System.out.print("Enter vehicle type (car/motorcycle/truck): ");
        String type = scanner.nextLine();

        System.out.print("Enter vehicle number: ");
        String vehicleNumber = scanner.nextLine();

        System.out.print("Enter manufacturer (Honda/Yamaha/Toyota/Suzuki): ");
        String manufacturer = scanner.nextLine();

        System.out.print("Enter year of manufacture: ");
        int yearOfManufacture = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine();

        System.out.print("Enter owner CMND: ");
        String cmnd = scanner.nextLine();

        System.out.print("Enter owner full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter owner email: ");
        String email = scanner.nextLine();

        Owner owner = new Owner(cmnd, fullName, email);

        Vehicle vehicle = null;
        switch (type.toLowerCase()) {
            case "car":
                System.out.print("Enter number of seats: ");
                int numberOfSeats = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter engine type: ");
                String engineType = scanner.nextLine();

                vehicle = new Car(vehicleNumber, manufacturer, yearOfManufacture, color, owner, numberOfSeats, engineType);
                break;

            case "motorcycle":
                System.out.print("Enter capacity: ");
                int capacity = scanner.nextInt();
                scanner.nextLine();

                vehicle = new Motorcycle(vehicleNumber, manufacturer, yearOfManufacture, color, owner, capacity);
                break;

            case "truck":
                System.out.print("Enter tonnage: ");
                int tonnage = scanner.nextInt();
                scanner.nextLine();

                vehicle = new Truck(vehicleNumber, manufacturer, yearOfManufacture, color, owner, tonnage);
                break;

            default:
                System.out.println("Invalid vehicle type.");
                return;
        }

        addVehicle(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    public void searchVehicleByNumber(Scanner scanner) {
        System.out.print("Enter vehicle number: ");
        String vehicleNumber = scanner.nextLine();

        Vehicle vehicle = searchVehicleByNumber(vehicleNumber);
        if (vehicle != null) {
            System.out.println("Vehicle found: " + vehicle);
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    public void findVehiclesByOwnerCmnd(Scanner scanner) {
        System.out.print("Enter owner CMND number: ");
        String cmnd = scanner.nextLine();

        List<Vehicle> vehicles = findVehiclesByOwnerCmnd(cmnd);
        if (!vehicles.isEmpty()) {
            System.out.println("Vehicles owned by CMND " + cmnd + ":");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        } else {
            System.out.println("No vehicles found for this owner.");
        }
    }

    public void deleteVehiclesByManufacturer(Scanner scanner) {
        System.out.print("Enter manufacturer: ");
        String manufacturer = scanner.nextLine();

        deleteVehiclesByManufacturer(manufacturer);
        System.out.println("All vehicles of manufacturer " + manufacturer + " have been deleted.");
    }

    public void indicateManufacturerWithMostVehicles() {
        String manufacturer = getManufacturerWithMostVehicles();
        System.out.println("Manufacturer with the most vehicles: " + manufacturer);
    }

    public void sortAndDisplayVehiclesByNumber() {
        sortVehiclesByNumber();
        System.out.println("Vehicles sorted by vehicle number.");
        for (Vehicle vehicle : getVehicles()) {
            System.out.println(vehicle);
        }
    }
}
