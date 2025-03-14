import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many Guns do you want to have? ");
        int numGuns = getValidInput(scanner);

        System.out.print("How many Knives do you want to have? ");
        int numKnives = getValidInput(scanner);

        System.out.print("How many Iron Swords do you want to have? ");
        int numIronSwords = getValidInput(scanner);

        System.out.print("How many Stones do you want to have? ");
        int numStones = getValidInput(scanner);


        System.out.println("\nGenerating items...");
        for (int i = 0; i < numGuns; i++) {
            inventory.addItem(inventory.generateRandomItem("Gun"));
        }
        for (int i = 0; i < numKnives; i++) {
            inventory.addItem(inventory.generateRandomItem("Knife"));
        }
        for (int i = 0; i < numIronSwords; i++) {
            inventory.addItem(inventory.generateRandomItem("Iron Sword"));
        }
        for (int i = 0; i < numStones; i++) {
            inventory.addItem(inventory.generateRandomItem("Stone"));
        }

        System.out.println("Initial Inventory:");
        inventory.displayInventory();


        System.out.println("\nTesting upgrades for each item type...");


        System.out.println("\nUpgrading a Common Gun...");
        if (inventory.upgradeItem("Gun", Rarity.COMMON, 0)) {
            System.out.println("Upgrade successful!");
        } else {
            System.out.println("Upgrade failed! Not enough Common Guns.");
        }

        System.out.println("\nUpgrading a Common Knife...");
        if (inventory.upgradeItem("Knife", Rarity.COMMON, 0)) {
            System.out.println("Upgrade successful!");
        } else {
            System.out.println("Upgrade failed! Not enough Common Knives.");
        }


        System.out.println("\nUpgrading a Common Iron Sword...");
        if (inventory.upgradeItem("Iron Sword", Rarity.COMMON, 0)) {
            System.out.println("Upgrade successful!");
        } else {
            System.out.println("Upgrade failed! Not enough Common Iron Swords.");
        }


        System.out.println("\nUpgrading a Common Stone...");
        if (inventory.upgradeItem("Stone", Rarity.COMMON, 0)) {
            System.out.println("Upgrade successful!");
        } else {
            System.out.println("Upgrade failed! Not enough Common Stones.");
        }


        System.out.println("\nInventory after upgrades:");
        inventory.displayInventory();
    }

    private static int getValidInput(Scanner scanner) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input >= 0) {
                    return input;
                } else {
                    System.out.print("Please enter a non-negative number: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}