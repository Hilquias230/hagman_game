import exception.GallowsException;
import model.HangmanGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a palavara para a pessoa adivinhar:");
        String word = scanner.nextLine();
        HangmanGame game = new HangmanGame(word);

        System.out.println("=== JOGO DA FORCA ===");

        while (!game.gameOver()) {

            System.out.println(game.getGallows());
            System.out.println("Palavra: " + game.getLettersparse());
            System.out.println("Letras erradas: " + game.getLettersIncorrect());
            System.out.print("Digite uma letra: ");

            String input = scanner.nextLine();

            if (input.length() != 1) {
                System.out.println("Digite apenas UMA letra!\n");
                continue;
            }

            char letter = input.charAt(0);

            try {
                game.letterTrying(letter);
            } catch (GallowsException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        System.out.println(game.getGallows());
        if (game.win()) {
            System.out.println("VOCÊ GANHOU! Você acertou: " + game.getLettersparse());
        } else {
            System.out.printf("VOCÊ PERDEU! A palavra era: %s", word);
        }
    }
}
