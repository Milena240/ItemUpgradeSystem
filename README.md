# 🎮 Item Upgrade System  

A simple program that generates random items (Knife, Gun, Stone, Iron Sword) based on user input, assigning them a rarity. The program then upgrades **only common rarity items** once, allowing users to check the upgrade functionality.

## 🔥 Features
- Users input the **number of each item** (Knife, Gun, Stone, Iron Sword).
- Items are **randomly generated** with different rarities.
- Rarity types:  
  - **Common**
  - **Great**
  - **Rare**
  - **Epic**
  - **Legendary**
- Only **common rarity items** get upgraded **once** (for testing).

## Example output

How many Guns do you want to have? 20
How many Knives do you want to have? 30
How many Iron Swords do you want to have? 40
How many Stones do you want to have? 50

Generating items...
Initial Inventory:

=== Inventory ===

Knife:
COMMON: 15
GREAT: 6
RARE: 7
EPIC: 2

Gun:
COMMON: 9
GREAT: 4
RARE: 5
EPIC: 2

Iron Sword:
COMMON: 19
GREAT: 11
RARE: 7
EPIC: 2
LEGENDARY: 1

Stone:
COMMON: 21
GREAT: 12
RARE: 10
EPIC: 6
LEGENDARY: 1

Testing upgrades for each item type...

Upgrading a Common Gun...
Upgrade successful!

Upgrading a Common Knife...
Upgrade successful!

Upgrading a Common Iron Sword...
Upgrade successful!

Upgrading a Common Stone...
Upgrade successful!

Inventory after upgrades:

=== Inventory ===

Knife:
COMMON: 12
GREAT: 7
RARE: 7
EPIC: 2

Gun:
COMMON: 6
GREAT: 5
RARE: 5
EPIC: 2

Iron Sword:
COMMON: 16
GREAT: 12
RARE: 7
EPIC: 2
LEGENDARY: 1

Stone:
COMMON: 18
GREAT: 13
RARE: 10
EPIC: 6
LEGENDARY: 1
