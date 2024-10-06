public class HiddenWord {

    private final String hiddenWord;

    public HiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord.toUpperCase();
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public String getHint(String guess) {
        if (!guess.equals(guess.toUpperCase())) {
            throw new IllegalArgumentException("Your guess ( " + guess + " ) does not contain all uppercase letters. Your guess must contain all uppercase letters!");
        }

        if (guess.length() != hiddenWord.length()) {
            throw new IllegalArgumentException("Your guess ( " + guess + " ) has " + guess.length() + " characters. The hidden word has " + hiddenWord.length() + " characters. Your guess must be a word with " + hiddenWord.length() + " characters!");
        }

        StringBuilder hint = new StringBuilder();

        for (int i = 0; i < hiddenWord.length(); i++) {
            char hChar = hiddenWord.charAt(i);
            char gChar = guess.charAt(i);

            if (gChar == hChar) {
                hint.append(hChar);
            } else if (hiddenWord.contains(String.valueOf(gChar))) {
                hint.append('+');
            } else {
                hint.append('*');
            }
        }

        return hint.toString();
    }
}