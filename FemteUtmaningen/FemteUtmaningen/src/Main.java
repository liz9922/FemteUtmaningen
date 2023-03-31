import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = createVehicles();

        printVehicleDetails(vehicles);
    }

    private static ArrayList<Vehicle> createVehicles() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("BMW", "M5", 220, 2015, 5));
        vehicles.add(new Truck("Scania", "340", 100, 2009, 4));
        vehicles.add(new Motorcycle("Yamaha", "Maisto", 300, 2023, true));

        return vehicles;
    }

    private static void printVehicleDetails(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println("\nMärke: " + vehicle.brand);
            System.out.println("Modell: " + vehicle.model);
            System.out.println("Årsmodell: " + vehicle.year);
            System.out.println("Topphastighet: " + vehicle.getMaxSpeed() + " km/h");
            System.out.println("Bränsleförbrukning: " + vehicle.getFuelConsumption() + " liter per 100 km");

            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                System.out.println("Antal dörrar: " + car.doors);
            }
            else if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                System.out.println("Max kapacitet: " + truck.capacity + " ton");
            }
            else if (vehicle instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                String hasWindShield = motorcycle.windShield ? "Ja" : "Nej";
                System.out.println("Har vindruta: " + hasWindShield);
            }

            float fuelNeeded = (float) (2 * vehicle.getFuelConsumption() / 100 * 200);
            System.out.println("För att köra från Göteborg till Malmö krävs det " + fuelNeeded + " liter bränsle.");
        }
    }
}