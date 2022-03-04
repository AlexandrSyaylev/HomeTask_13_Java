package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> playerReg = new ArrayList<>();

    public void register(Player player) {
        playerReg.add(player);
    }

    public int round(String playerName1, String playerName2) {

        try {
            searchBy(playerName1);

        } catch (NotFoundException e) {
            System.out.println("Player " + playerName1 + " is not registered");
        }
        try {
            searchBy(playerName2);
        } catch (NotFoundException e) {
            System.out.println("Player " + playerName2 + " is not registered");
        }

        if (searchBy(playerName1).getStrength() > searchBy(playerName2).getStrength()) {
            return 1;
        }
        if (searchBy(playerName1).getStrength() < searchBy(playerName2).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

    public Player searchBy(String playername) {
        for (Player player : playerReg) {
            if (player.getName().equals(playername)) {
                return player;
            }
        }
        return null;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Player product, String search) {
        if (product.getName().contains(search)) {
            return product.getName().contains(search);
        }
        return false;
    }
}
