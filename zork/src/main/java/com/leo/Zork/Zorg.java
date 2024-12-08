/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.leo.Zork;

import com.leo.Zork.game.Game;

/**
 *
 * @author codespace
 */
public class Zorg {

    public static void main(String[] args) {
        System.out.println("Game is starting....");
        Game game = new Game();
        game.initialize();
        game.startGameLoop();
    }
}
