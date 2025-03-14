
import java.util.*;
public class Inventory{
    private Map<String, Map<Rarity, List<Item>>> items;

    public Inventory(){
        items = new HashMap<>();
    }

    public void addItem(Item item){
        Map<Rarity, List<Item>> byRarity = items.computeIfAbsent(item.getName(), k -> new HashMap<>());

        List<Item> itemsList = byRarity.computeIfAbsent(item.getRarity(), k -> new ArrayList<>());
        itemsList.add(item);
    }

    public boolean upgradeItem(String name, Rarity rarity, int upgradeCount) {
        Map<Rarity, List<Item>> byname = items.get(name);
        if (byname == null) return false;

        List<Item> itemsList = byname.get(rarity);
        if (itemsList == null) return false;

        if (rarity == Rarity.EPIC && upgradeCount > 0) {
            return epicUpgrade(name, upgradeCount);
        }

        int countToCheck = (rarity == Rarity.EPIC) ? 2 : 3;
        if (itemsList.size() < countToCheck) {
            System.out.println("There are not enought " + rarity + " " + name + " to upgrade");
            return false;
        }

        for (int i = 0; i < countToCheck-1; i++) {
            itemsList.remove(0);
        }

        Item target = itemsList.remove(0);
        if (rarity == Rarity.EPIC) {
            target.setUpgradeCount(1);
        } else if (rarity != Rarity.LEGENDARY) {
            target.setRarity(rarity.getNextRarity());
        }

        addItem(target);
        return true;
    }
        private boolean epicUpgrade(String name, int upgradeCount){
            Map<Rarity, List<Item>> byName = items.get(name);
            List<Item> epicRarityItems = byName.get(Rarity.EPIC);

            if (epicRarityItems == null) return false;

            Item target = null;
            for (Item item : epicRarityItems){
                if (item.getUpgradeCount() == upgradeCount){
                    target = item;
                    break;
                }
            }
            if (target == null) return false;

            if (upgradeCount == 2){
                int countEpic2 = 0;
                for(Item item : epicRarityItems){
                    if (item.getUpgradeCount() == 2)
                        countEpic2++;
                }if (countEpic2<3) return false;

                int removed = 0;
                Iterator<Item> iterator = epicRarityItems.iterator();
                while (iterator.hasNext() && removed <2){
                    Item item = iterator.next();
                    if (item.getUpgradeCount() == 2 && item != target) {
                        iterator.remove();
                        removed++;
                    }
                }
                epicRarityItems.remove(target);
                target.setRarity(Rarity.LEGENDARY);
                target.setUpgradeCount(0);
            } else {
                if (epicRarityItems.size() <2) return false;
                Iterator<Item> iterator = epicRarityItems.iterator();
                while (iterator.hasNext()) {
                    Item item = iterator.next();
                    if (item != target) {
                        iterator.remove();
                        break;
                    }
                }
                epicRarityItems.remove(target);
                target.setUpgradeCount(upgradeCount + 1);
            }

            addItem(target);
            return true;
        }

    public void displayInventory() {
        System.out.println("\n=== Inventory ===");
        for (String name : items.keySet()) {
            System.out.println("\n" + name + ":");
            Map<Rarity, List<Item>> itemsByRarity = items.get(name);
            for (Rarity rarity : Rarity.values()) {
                List<Item> itemList = itemsByRarity.get(rarity);
                if (itemList != null && !itemList.isEmpty()) {
                    int count = itemList.size();
                    System.out.println(rarity + ": " + count);
                }
            }
        }
    }


    public Item generateRandomItem(String name) {
        Random rand = new Random();
        double roll = rand.nextDouble();

        if (roll < 0.50) return new Item(name, Rarity.COMMON, 0);      // 50%
        else if (roll < 0.75) return new Item(name, Rarity.GREAT, 0);  // 25%
        else if (roll < 0.90) return new Item(name, Rarity.RARE, 0);   // 15%
        else if (roll < 0.98) return new Item(name, Rarity.EPIC, 0);   // 8%
        else return new Item(name, Rarity.LEGENDARY, 0);               // 2%
    }

}







