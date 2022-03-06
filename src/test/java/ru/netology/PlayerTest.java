package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player = new Player();

    @Test
    void getAndSetId() {
        player.setId(5);
        int expected = 5;
        int actual = player.getId();
        assertEquals(expected, actual);
    }

    @Test
    void setAndGetName() {
        player.setName("f");
        String expected = "f";
        String actual = player.getName();
        assertEquals(expected, actual);
    }

    @Test
    void setStrength() {
        player.setStrength(5);
        int expected = 5;
        int actual = player.getStrength();
        assertEquals(expected, actual);
    }
}