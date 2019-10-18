package at.techtalk.Hangman;

import org.junit.Assert;
import org.junit.Test;

public class HangmanTest {

    @Test
    public void testShowEmptyGuesses() {
        Hangman hangman = new Hangman("Developer");
        String guesses = hangman.getGuesses();
        Assert.assertEquals("---------", guesses);
    }

    @Test
    public void testShowWrongGuess() {
        Hangman hangman = new Hangman("Developer");
        hangman.guess('u');
        String guesses = hangman.getGuesses();
        Assert.assertEquals("---------", guesses);
    }


    @Test
    public void testShowAfterOneRightGuess() {
        Hangman hangman = new Hangman("Developer");
        hangman.guess('e');
        String guesses = hangman.getGuesses();
        Assert.assertEquals("-e-e---e-", guesses);
    }

    @Test
    public void testShowAfterWrongCaseRightGuess() {
        Hangman hangman = new Hangman("Developer");
        hangman.guess('E');
        String guesses = hangman.getGuesses();
        Assert.assertEquals("-e-e---e-", guesses);
    }

    @Test
    public void testShowAfterAllRightGuess() {
        Hangman hangman = new Hangman("Developer");
        hangman.guess('e');
        hangman.guess('D');
        hangman.guess('v');
        hangman.guess('l');
        hangman.guess('o');
        hangman.guess('p');
        hangman.guess('r');
        String guesses = hangman.getGuesses();
        Assert.assertEquals("Developer", guesses);
    }

    @Test
    public void testShowRemainingGuesses() {
        Hangman hangman = new Hangman("Developer");
        final int remainingGuesses = hangman.getRemainingGuesses();
        Assert.assertEquals(5, remainingGuesses);
    }

    @Test
    public void testShowRemainingGuessesGuessWrong() {
        Hangman hangman = new Hangman("Developer");
        hangman.guess('u');
        final int remainingGuesses = hangman.getRemainingGuesses();
        Assert.assertEquals(4, remainingGuesses);
    }

    @Test
    public void testShowRemainingGuessesGuessRight() {
        Hangman hangman = new Hangman("Developer");
        hangman.guess('e');
        final int remainingGuesses = hangman.getRemainingGuesses();
        Assert.assertEquals(5, remainingGuesses);
    }

    @Test
    public void testShowGameState() {
        Hangman hangman = new Hangman("Developer");
        GameState state = hangman.getGameState();
        Assert.assertEquals(GameState.RUNNING, state);
    }

    @Test
    public void testShowGameStateIfWon() {
        Hangman hangman = new Hangman("Developer");
        hangman.guess('e');
        hangman.guess('D');
        hangman.guess('v');
        hangman.guess('l');
        hangman.guess('o');
        hangman.guess('p');
        hangman.guess('r');
        GameState state = hangman.getGameState();
        Assert.assertEquals(GameState.WON, state);
    }

    @Test
    public void testShowGameStateIfLost() {
        Hangman hangman = new Hangman("Developer");
        hangman.guess('u');
        hangman.guess('q');
        hangman.guess('w');
        hangman.guess('s');
        hangman.guess('c');
        GameState state = hangman.getGameState();
        Assert.assertEquals(GameState.LOST, state);
    }
}
