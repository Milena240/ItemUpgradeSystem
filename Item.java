import java.io.*;
import java.util.*;

public class Item {
    private String name;
    private Rarity rarity;
    private int upgradeCount;


    public Item(String name, Rarity rarity, int upgradeCount){
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = upgradeCount;
    }


    public void setRarity(Rarity rarity){
        this.rarity = rarity;
    }
    public void setUpgradeCount(int upgradeCount){
        this.upgradeCount = upgradeCount;
    }
    public String getName() {
        return name;
    }
    public int getUpgradeCount() {
        return upgradeCount;
    }
    public Rarity getRarity() {
        return rarity;
    }

    @Override
    public String toString(){
        String stirng = name + " [" + rarity;
        if (rarity == Rarity.EPIC && upgradeCount > 0){   //handling case for Epic 1 2
            stirng += " " + upgradeCount;
        }
        return stirng + "] ";
    }

}




