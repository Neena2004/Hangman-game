import java.util.ArrayList;
import java.util.Scanner;

class Item {
    int id;
    String name;
    int quantity;
    float price;

    Item(int id, String name, int quantity, float price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}

public class InventoryManagementSystem {
    static final int MAX_ITEMS = 100;
    static ArrayList<Item> inventory = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Function to add a new item
    public static void addItem() {
        if (inventory.size() >= MAX_ITEMS) {
            System.out.println("Cannot add more items. The inventory is full.");
            return;
        }
        System.out.print("Enter Item ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Item Name: ");
        String name = scanner.next();
        System.out.print("Enter Item Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Item Price: ");
        float price = scanner.nextFloat();
        inventory.add(new Item(id, name, quantity, price));
        System.out.println("Item added successfully!");
    }

    // Function to display all items
    public static void displayItems() {
        if (inventory.size() == 0) {
            System.out.println("No items to display.");
            return;
        }
        System.out.println("ID\tName\t\tQuantity\tPrice");
        System.out.println("---------------------------------------------");
        for (Item item : inventory) {
            System.out.printf("%d\t%s\t\t%d\t\t%.2f\n", item.id, item.name, item.quantity, item.price);
        }
    }

    // Function to search for an item by ID
    public static void searchItem() {
        System.out.print("Enter Item ID to search: ");
        int id = scanner.nextInt();
        for (Item item : inventory) {
            if (item.id == id) {
                System.out.println("Item found:");
                System.out.println("ID: " + item.id);
                System.out.println("Name: " + item.name);
                System.out.println("Quantity: " + item.quantity);
                System.out.println("Price: " + item.price);
                return;
            }
        }
        System.out.println("Item with ID " + id + " not found.");
    }

    // Function to delete an item by ID
    public static void deleteItem() {
        System.out.print("Enter Item ID to delete: ");
        int id = scanner.nextInt();
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).id == id) {
                inventory.remove(i);
                System.out.println("Item with ID " + id + " deleted successfully.");
                return;
            }
        }
        System.out.println("Item with ID " + id + " not found.");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Display Items");
            System.out.println("3. Search Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    displayItems();
                    break;
                case 3:
                    searchItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
