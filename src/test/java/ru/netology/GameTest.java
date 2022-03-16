package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    Player first = new Player(1, "f", 10);
    Player second = new Player(2, "s", 11);
    Player third = new Player(3, "t", 9);
    Player fourth = new Player(4, "p", 10);
    Player secondDouble = new Player(5, "s", 15);
    Player thirdChiter = new Player(3, "t", 100);

    @Test
    public void shouldRegisterAndSearchPlayer() {
        game.register(first);
        Player expected = (game.searchBy("f"));
        Player actual = first;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundRegisteredPlayersFirstWin() {
        game.register(first);
        game.register(third);
        int expected = 1;
        int actual = game.round("f", "t");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundRegisteredPlayersSecondWin() {
        game.register(third);
        game.register(second);
        int expected = 2;
        int actual = game.round("t", "s");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundRegisteredNoWinner() {
        game.register(first);
        game.register(fourth);
        int expected = 0;
        int actual = game.round("f", "p");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundNonRegPlayer() {
        game.register(first);
        game.register(fourth);
        NotRegisteredException thrown = assertThrows(NotRegisteredException.class, () -> game.round("f", "s"));
    }
    /*@Test
    public void shouldRoundNonRegPlayer() {
        game.register(first);
        game.register(fourth);
        int expected = 0;
        try {
            int actual = game.round("f", "s");
            assertEquals(expected, actual);
        } catch (NotRegisteredException e) {
            System.out.println("Player is not registered");
        }
    }*/

    @Test
    public void shouldRoundPlayerOneNameDifferentId() {
        game.register(second);
        game.register(secondDouble);
        int expected = 0; //because game.searchBy will find only first similar name, such we return one element, not Array
        int actual = game.round("s", "s");
        assertEquals(expected, actual);

    }
/*
    //we nowhere check id, so this field is not used in our code, we can remove it
    // as s task, we must compare players only by strength (as field as player characteristics), not such objects.
    @Test
    public void shouldRoundPlayerOneId() {

    }
*/


}