package com.leo.Zork.game;

import java.util.Arrays;

/**
 * Inventory to hold items as a String array.
 */
public class Inventory {

    private String[] items;
    private int capacity;
    private int itemCount;

    public Inventory(int capacity) {
        this.capacity = capacity;
        this.items = new String[capacity];
        this.itemCount = 0;
    }

    /**
     * Add an item to the inventory.
     *
     * @param item The item to add.
     * @return true if the item was added successfully, false if the inventory is full.
     */
    public boolean addItem(String item) {
        if (itemCount < capacity) {
            items[itemCount++] = item;
            return true;
        }
        System.out.println("Inventory is full. Cannot add: " + item);
        return false;
    }

    /**
     * Get all items in the inventory.
     *
     * @return A copy of the items array.
     */
    public String[] getItems() {
        return Arrays.copyOf(items, itemCount);
    }

    /**
     * Remove an item from the inventory.
     *
     * @param item The item to remove.
     * @return true if the item was successfully removed, false if the item was not found.
     */
    public boolean removeItem(String item) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].equalsIgnoreCase(item)) {
                // Shift remaining items left
                System.arraycopy(items, i + 1, items, i, itemCount - i - 1);
                items[--itemCount] = null; // Clear the last slot
                return true;
            }
        }
        System.out.println("Item not found: " + item);
        return false;
    }

    /**
     * Check if the inventory contains an item.
     *
     * @param item The item to check.
     * @return true if the inventory contains the item, false otherwise.
     */
    public boolean contains(String item) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].equalsIgnoreCase(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Display all items in the inventory.
     */
    public void displayInventory() {
        if (itemCount == 0) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You are carrying:");
            for (int i = 0; i < itemCount; i++) {
                System.out.println("- " + items[i]);
            }
        }
    }
}
