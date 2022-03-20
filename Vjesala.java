import java.util.Arrays;
import java.util.Scanner;

public class Vjesala {

    public static String[] words = { "babun", "medvjed", "kamila",
            "macka", "kobra", "kojot", "jelen",
            "pas", "patka", "soko", "lisica", "zaba", "koza",
            "orao", "lav", "majmun", "mis",
            "mula", "panda", "papagaj",
            "zec", "pacov", "krava",
            "ovca", "zmija", "pauk", "svinja",
            "patka", "kornjaca", "kit", "vuk",
            "sismis", "zebra" };

    public static String[] parts = { "+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n" };

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String word = randomWord();

        char[] placeholders = new char[word.length()];
        for (int i = 0; i < placeholders.length; i++) {
            placeholders[i] = '_';
        }

        int misses = 0;

        char[] missedGuesses = new char[6];

        while (misses < 6) {
            System.out.print(parts[misses]);

            System.out.print("Rijec:   ");
            printPlaceholders(placeholders);
            System.out.print("\n");

            System.out.print("Iskoristena slova:   ");
            printMissedGuesses(missedGuesses);
            System.out.print("\n\n");

            System.out.print("Pogodjena slova:   ");
            char guess = scan.nextLine().charAt(0);
            System.out.print("\n");

            if (checkGuess(word, guess)) {
                updatePlaceholders(word, placeholders, guess);
            } else {
                missedGuesses[misses] = guess;
                misses++;
            }

            if (Arrays.equals(placeholders, word.toCharArray())) {
                System.out.print(parts[misses]);
                System.out.print("\nRijec:   ");
                printPlaceholders(placeholders);
                System.out.println("\nBravo!");
                break;
            }
        }

        if (misses == 6) {
            System.out.print(parts[6]);
            System.out.println("\nObjsen!");
            System.out.println("\nRijec je bila: '" + word + "'");
        }
        scan.close();
    }

    public static String randomWord() {
        int numWords = words.length;
        double randomDouble = Math.random();
        int randomIndex = (int) (randomDouble * numWords);
        return words[randomIndex];
    }

    public static boolean checkGuess(String word, char guess) {

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                return true;
            }
        }
        return false;

    }

    public static void updatePlaceholders(String word, char[] placeholders, char guess) {

        for (int j = 0; j < word.length(); j++) {

            if (word.charAt(j) == guess) {
                placeholders[j] = guess;
            }
        }
    }

    public static void printPlaceholders(char[] placeholders) {
        for (int i = 0; i < placeholders.length; i++) {
            System.out.print(" " + placeholders[i]);
        }
        System.out.print("\n");
    }

    public static void printMissedGuesses(char[] misses) {
        for (int i = 0; i < misses.length; i++) {
            System.out.print(misses[i]);
        }
    }
}
