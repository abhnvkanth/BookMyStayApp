import java.util.HashMap;
import java.util.Map;

/*
 * Book My Stay App
 * Use Case 3.1 – Centralized Room Inventory Management
 */

// Inventory class responsible for managing room availability
class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor initializes room availability
    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 10);
        inventory.put("Double Room", 6);
        inventory.put("Suite Room", 3);
    }

    // Retrieve availability for a room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability (controlled update)
    public void updateAvailability(String roomType, int newCount) {
        if (inventory.containsKey(roomType)) {
            inventory.put(roomType, newCount);
        } else {
            System.out.println("Room type not found in inventory.");
        }
    }

    // Display current inventory state
    public void displayInventory() {
        System.out.println("===== Current Room Inventory =====");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " rooms available");
        }
    }
}


// Main class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Book My Stay - Room Inventory System (Version 3.1)\n");

        // Initialize inventory system
        RoomInventory inventory = new RoomInventory();

        // Display current inventory
        inventory.displayInventory();

        System.out.println("\nChecking availability for Double Room:");
        System.out.println("Available: " + inventory.getAvailability("Double Room"));

        // Example update
        System.out.println("\nUpdating Double Room availability to 5...\n");
        inventory.updateAvailability("Double Room", 5);

        // Display updated inventory
        inventory.displayInventory();
    }
}