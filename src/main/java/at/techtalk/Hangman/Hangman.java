package at.techtalk.Hangman;

public class Hangman {
    private final String input;
    private String guessed;
    private int remainingGuesses = 5;

    public Hangman(String input) {
        this.input = input;
        this.guessed = input.replaceAll(".", "-");
    }

    public String getGuesses() {
        return guessed;
    }

    public void guess(char character) {
        boolean guessedRight = false;
        StringBuilder builder = new StringBuilder(guessed);
        for(int i = 0; i<input.length(); i++) {
            if(Character.toLowerCase(input.charAt(i)) == Character.toLowerCase(character)) {
                builder.setCharAt(i,input.charAt(i));
                guessedRight = true;
            }
        }
        guessed = builder.toString();
        if(!guessedRight) {
            remainingGuesses--; // remainingGuesses -= 1; remainingGuesses = remainingGuesses - 1;
        }
    }

    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    public GameState getGameState() {
        if(remainingGuesses <= 0) {
            return GameState.LOST;
        }
        if(guessed.equals(input)) {
            return GameState.WON;
        }
        return GameState.RUNNING;
    }
}
