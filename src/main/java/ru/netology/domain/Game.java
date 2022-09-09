package ru.netology.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> playerList = new ArrayList<>();

    public void register(Player player) {
        playerList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        int result = 0;

        for (Player player : playerList) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException("Player: " + playerName1 + " is not registered");
        } else if (player2 == null) {
            throw new NotRegisteredException("Player: " + playerName2 + " is not registered");
        }

        if (player1.getStrength() > player2.getStrength()) {
            result = 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            result = 2;
        }
        return result;
    }

    public Player findByName(String name) {
        Player info = null;
        for (Player player : playerList) {
            if (player.getName().equals(name)) {
                info = player;
            }
        }
        return info;
    }
}
