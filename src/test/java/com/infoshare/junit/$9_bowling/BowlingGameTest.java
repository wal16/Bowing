package com.infoshare.junit.$9_bowling;

import com.infoshare.junit.bowling.Game;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    private Game game;

    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void should_score_zero_when_no_pins_were_knocked() {
        rollMany(20, 0);
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void should_score_20_when_every_roll_knocks_down_one_pin() {
        rollMany(20, 1);
        assertThat(game.score()).isEqualTo(20);
    }

    @Test
    public void should_treat_empty_rolls_as_misses() {
        rollMany(3,1);
        assertThat(game.score()).isEqualTo(3);
    }

    // TODO use parametrized
    @Test
    public void should_have_correct_score_for_game_without_bonuses() {
        rollMany(20, 1);
        assertThat(game.score()).isEqualTo(20);
    }

    @Test
    public void should_have_correct_score_for_one_spare() {
        rollSpare();
        game.roll(3);
        assertThat(game.score()).isEqualTo(16);
    }

    @Test
    public void should_have_correct_score_for_one_strike(){
        rollStrike();
        game.roll(3);
        game.roll(4);
        assertThat(game.score()).isEqualTo(24);
    }

    @Test
    public void should_correctly_score_perfect_game() {
        rollMany(10,10);
        rollMany(2,10);
        assertThat(game.score()).isEqualTo(300);
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }


}
