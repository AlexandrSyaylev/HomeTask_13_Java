package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> playerReg = new ArrayList<>();

    public void register(Player player) {
        playerReg.add(player);
    }

    public int round(String playerName1, String playerName2) {

        checkForRegistered(playerName1);
        checkForRegistered(playerName2);
        if (searchBy(playerName1).getStrength() > searchBy(playerName2).getStrength()) {
            return 1;
        }
        if (searchBy(playerName1).getStrength() < searchBy(playerName2).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

    public void checkForRegistered(String name) throws NotRegisteredException {
        if (searchBy(name) == null) {
            throw new NotRegisteredException("Player " + name + " is not registered");
        }
    }

    public Player searchBy(String playerName) {
        for (Player player : playerReg) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

}
