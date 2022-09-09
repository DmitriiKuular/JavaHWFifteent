package ru.netology.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    Player player1 = new Player(11, "Petya", 15);
    Player player2 = new Player(22, "Kolya", 11);
    Player player3 = new Player(33, "Katya", 6);
    Player player4 = new Player(33, "Tolya", 0);
    Player player5 = new Player(33, "Gosha", 0);

    Game game = new Game();

    @Test
    public void shouldShowExceptionPlayer1() {
        game.register(player2);
        assertThrows(NotRegisteredException.class, () -> {game.round("Petya", "Kolya");});
    }

    @Test
    public void shouldShowExceptionPlayer2() {
        game.register(player1);
        assertThrows(NotRegisteredException.class, () -> {game.round("Petya", "Kolya");});
    }


    @Test
    public void shouldShowWinnerPlayer1() {
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Petya", "Kolya");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldShowWinnerPlayer2() {
        game.register(player1);
        game.register(player2);
        player2.setStrength(18);
        int expected = 2;
        int actual = game.round("Petya", "Kolya");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotShowWinner() {
        game.register(player1);
        game.register(player2);
        player2.setStrength(15);
        int expected = 0;
        int actual = game.round("Petya", "Kolya");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotShowWinnerIfZero() {
        game.register(player4);
        game.register(player5);
        int expected = 0;
        int actual = game.round("Gosha", "Tolya");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByName() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        Player expected = player2;
        Player actual = game.findByName("Kolya");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByName() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        Player expected = null;
        Player actual = game.findByName("Jija");
        assertEquals(expected, actual);
    }
}
