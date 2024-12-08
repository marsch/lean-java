package com.leo.Zork.game;

import java.util.Scanner;

/**
 *
 * @author codespace
 */
public class Game {

    private Inventory inventory;

    public Game() {
        System.out.println("Game instance created");
        inventory = new Inventory(5);
    }

    public void initialize() {
        System.out.println("Game instance initializing...");
        System.out.println("Type /help for a list of commands or start interacting.");
    }

    public void startGameLoop() {
        System.out.println("Game loop starting...");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            // Split command and arguments
            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            String arguments = parts.length > 1 ? parts[1] : "";

            switch (command) {
                case "/quit":
                    System.out.println("Exiting the game...");
                    running = false;
                    break;

                case "/help":
                    showHelp();
                    break;

                case "look":
                    handleLook(arguments);
                    break;

                case "go":
                    handleGo(arguments);
                    break;

                case "take":
                    handleTake(arguments);
                    break;

                case "drop":
                    handleDrop(arguments);
                    break;

                case "inventory":
                    showInventory();
                    break;

                default:
                    System.out.println("I don't understand that command.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Game loop ended.");
    }

    // Command handlers

    // TODO: implement logic
    private void handleLook(String arguments) {
        if (arguments.isEmpty()) {
            System.out.println("You look around but see nothing special.");
        } else {
            System.out.println("You look at " + arguments + " and see nothing out of the ordinary.");
        }
    }

    // TODO: implement logic
    private void handleGo(String arguments) {
        if (arguments.isEmpty()) {
            System.out.println("Go where? You need to specify a direction.");
        } else {
            System.out.println("You go " + arguments + ".");
        }
    }

    private void handleTake(String arguments) {
        if (arguments.isEmpty()) {
            System.out.println("Take what?");
        } else {
            System.out.println("You take the " + arguments + ".");
            inventory.addItem(arguments);
        }
    }

    private void handleDrop(String arguments) {
        if (arguments.isEmpty()) {
            System.out.println("Drop what?");
        } else {
            System.out.println("You drop the " + arguments + ".");
            inventory.removeItem(arguments);
        }
    }

    private void showInventory() {
        inventory.displayInventory();
    }

    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("/help - Show this help message.");
        System.out.println("/quit - Quit the game.");
        System.out.println("look [entity] - Look around or at a specific entity.");
        System.out.println("go [direction] - Move in a specified direction.");
        System.out.println("take [item] - Take an item.");
        System.out.println("drop [item] - Drop an item.");
        System.out.println("inventory - Check what you are carrying.");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.initialize();
        game.startGameLoop();
    }
}
