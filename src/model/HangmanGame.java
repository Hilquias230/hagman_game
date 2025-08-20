package model;

import exception.GallowsException;

import java.util.HashSet;
import java.util.Set;

public class HangmanGame {
    private final String lettersSecret;
    private Set<Character> lettersCorrect = new HashSet<>();
    private Set<Character> lettersIncorrect = new HashSet<>();
    private int erros = 0;

    public HangmanGame(String lettersSecret) {
        this.lettersSecret = lettersSecret.toUpperCase();
    }


    public boolean gameOver() {
        return erros >= StateGallows.values().length - 1 || lettersComplet();
    }

    public boolean win() {
        return lettersComplet();
    }


    public void letterTrying(char letters) throws GallowsException {
        letters = Character.toUpperCase(letters);

        if (!Character.isLetter(letters)) {
            throw new GallowsException("Digite apenas letras!");
        }

        if (lettersCorrect.contains(letters) || lettersIncorrect.contains(letters)) {
            throw new GallowsException("Você já tentou essa letra!");
        }

        if (lettersSecret.indexOf(letters) >= 0) {
            lettersCorrect.add(letters);
        } else {
            lettersIncorrect.add(letters);
            erros++;
        }
    }

    public String getLettersparse() {
        StringBuilder sb = new StringBuilder();
        for (char c : lettersSecret.toCharArray()) {
            if (lettersCorrect.contains(c)) {
                sb.append(c).append(" ");
            } else {
                sb.append("_ ");
            }
        }
        return sb.toString();
    }


    public String getGallows() {
        return StateGallows.values()[erros].getGallows();
    }


    public String getLettersIncorrect() {
        return lettersIncorrect.toString();
    }

    private boolean lettersComplet() {
        for (char c : lettersSecret.toCharArray()) {
            if (!lettersCorrect.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
