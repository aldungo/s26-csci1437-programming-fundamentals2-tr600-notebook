//TRIES ARE SIX NOT LETTERS
//https://www.hangmanwords.com/words


/*

cant run c[i] x
words choose x

add         for (char x : guessedWord) {
            if (x == '\0') {
                return false;
                }
            }


*/

import java.util.Scanner;
import java.util.Random;
public class HanguMangu {
    public static final String[] WORDBANK = {"aatrox", "ahri","akali","akshan","alistar","amumu","anivia",
            "annie","aphelios","ashe","aurelionsol","azir","belveth","blitzcrank","brand","braum","briar","caitlyn","camille","cassiopeia","chogath",
            "corki","darius","diana","drmundo","draven","ekko","elise","evelynn","ezreal","fiddlesticks","fiora","fizz","galio","gangplank",
            "garen","gnar","gragas","graves","gwen","hecarim","heimerdinger","hwei","illaoi","irelia","ivern","janna","jarvan","jax",
            "jayce","jhin","jinx","ksante","kaisa","kalista","karma","karthus","kassadin","katarina","kayle","kayn","kennen","khazix",
            "kindred","kled","kogmaw","leblanc","leesin","leona","lillia","lissandra","lucian","lulu","lux","malphite","malzahar","maokai",
            "masteryi","milio","missfortune","mordekaiser","morgana","naafiri","nami","nasus","nautilus","neeko","nidalee","nilah","nocturne","nunu",
            "olaf","orianna","ornn","pantheon","poppy","pyke","qiyana","quinn","rakan","rammus","reksai","rell","renataglasc","renekton",
            "rengar","riven","rumble","ryze","samira","sejuani","senna","seraphine","sett","shaco","shen","shyvana","singed","sion",
            "sivir","skarner","sona","soraka","swain","sylas","syndra","tahmkench","taliyah","talon","taric","teemo","thresh","tristana",
            "trundle","tryndamere","twistedfate","twitch","udyr","urgot","varus","vayne","veigar","velkoz","vex","vi","viego","viktor",
            "vladimir","volibear","warwick","wukong","xayah","xerath","xinzhao","yasuo","yone","yorick","yuumi","zac","zed","zeri",
            "ziggs","zilean","zoe"};
    public static final int MAX_TRIES = 6;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        String wordGuess = WORDBANK[random.nextInt(WORDBANK.length)];
        char[] guessedWord = new char[wordGuess.length()];
        int attempts = 0;
        boolean wordGuessed = false;
        System.out.println("\n***************                    \n |    |\n |     \n |\n |\n |\n_|___" +
                "\nWord Bank Theme: League of Legends champions");
        while (attempts < MAX_TRIES && !wordGuessed) {
            System.out.println("\nWord chosen!!: " + displayWord(guessedWord));
            System.out.println("Attempts left: " + (MAX_TRIES - attempts));
            System.out.print("Enter a letter: ");
            char guess = input.next().toLowerCase().charAt(0);
            if (!(guess >= 'a' && guess <= 'z')) {
                System.out.println("That's not a letter come on");
                continue;
            }
            boolean correct = false;
            for (int i = 0; i < wordGuess.length(); i++) {
                if (wordGuess.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    correct = true;
                }
            }
            if (!correct) {
                attempts++;
                displayHangman(attempts);
                System.out.println("Wrong answer!");
            }
            if (correctWord(guessedWord)) {
                wordGuessed = true;
            }
        } //if correct  = win
        if (wordGuessed) {
            System.out.println("\nCongrats you got it\n<3 <3 <3");
        } else {
            System.out.println("\nwow, you're bad at this :( .\nThe word was:" + wordGuess);
            displayHangman(MAX_TRIES);
        }
    }
    // displayWord = for loop displaying String
    // displayHang = draw
    // checkWord = checker return false true
    //char x : word;

    //DISPLAYS RAMDOMLY CHOSEN WORD BLANK
    private static String displayWord(char[] guessedWord) {
        StringBuilder display = new StringBuilder();
        for (int i = 0; i < guessedWord.length; i++) {
            display.append(guessedWord[i] == '\0' ? "_ " : guessedWord[i] + " ");
        }
        return display.toString();
    }
    //DISPLAY DIFFERENT VERSIONS DEPENDING ON ATTEMPT #
    private static void displayHangman(int attempts) {
        switch (attempts) {
            case 1:
                System.out.println("\n********                    \n |    |\n |    O\n |\n |\n |\n_|___");
                break;
            case 2:
                System.out.println("  ********\n |    |\n |    O\n |    |\n |\n |\n_|___");
                break;
            case 3:
                System.out.println("  ********\n |    |\n |    O\n |   /|\n |\n |\n_|___");
                break;
            case 4:
                System.out.println("  ********\n |    |\n |    O\n |   /|\\\n |\n |\n_|___");
                break;
            case 5:
                System.out.println("  ********\n |    |\n |    O\n |   /|\\\n |   /\n |\n_|___");
                break;
            case 6:
                System.out.println("  ********\n |    |\n |    O\n |   /|\\\n |   / \\\n |\n_|___");
                break;
        }
    }

    //CHECK IS THE WORD HAS BEEN COMPLETELY GUESSED CORRECTLY
    public static boolean correctWord(char[] guessedWord) {
        for (char x : guessedWord) {
            if (x == '\0') {
                return false;
            }
        }
        return true;
    }
}
