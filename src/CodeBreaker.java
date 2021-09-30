import java.util.Scanner;
import java.util.Locale;

public class CodeBreaker {
   static String alphabet = "abcdefghijklmnopqrstuvwxyz";
   static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Welcome
        System.out.println("Welcome, lets play with codes, perhaps we can break them, we for sure will make them");
        System.out.println("\n");

        //Number to cypher encoder
        System.out.println("Lets start with a Number-Cypher-Encoder");
        System.out.println("Please input a word:");

        String userWord = scanner.nextLine();
        userWord = userWord.toLowerCase(Locale.ROOT);

        String wordToNumbers = cypherEncoder(userWord);
        System.out.println("Result: " + wordToNumbers);

        // Number to cypher decoder

        System.out.println("Lets decode, for the simplicity, we will continue with the results form your input");
        System.out.println("If you forgot your result was: " + wordToNumbers);
        String [] encodedWordInArray = wordToNumbers.split(";");
        String decodedWord = cypherDecoder(encodedWordInArray);
        String decodedWordForUser = decodedWord;
        System.out.println("Decyphered it is : " + decodedWordForUser);
        System.out.println("\n");

        //Ceasar cypher encoder
        System.out.println("Time for the Ceasar cypher");
        System.out.println("Please input a word, and lets see what happens :");
        String wordInputCeasar = scanner.next();
        wordInputCeasar = wordInputCeasar.toLowerCase(Locale.ROOT);
        String wordFromCeasarEncoder = ceasarEncoder(wordInputCeasar);
        String resultsCeasarEncoding = wordFromCeasarEncoder;
        System.out.println("Your input, has magically been transformed to:");
        System.out.println(wordFromCeasarEncoder);
        System.out.println("Probably don't make sense right? Thats the point :)");
        System.out.println("It helped Ceasars messages become hidden from spies");

        //Caesar cyper decoder
        System.out.println("Lets flip it back, we're not in rome anyways");
        System.out.println("Your word encoded word: " + wordFromCeasarEncoder + " back to normal");

        String decodedCeasarWord = ceasarDecoder(wordFromCeasarEncoder);
        String decodeResults = "Your decoded, back to normal";
        System.out.println(decodedCeasarWord);
    }

    //Methods

    //Method for converting a character to a number the same index, as the alphabet
    public static int charToIndex(char character){
        int charIndex = alphabet.indexOf(character) +1;
        return charIndex;
    }
    //Method for converting a number to a character the same index, as the alphabet
   public static char numberToChar(int index){
        char indexToChar = alphabet.charAt(index-1);
        return indexToChar;
   }

   // This method is to encode a string
   public static String cypherEncoder (String wordToNumbers){
        String encodedString ="";

        for (int i=0; i < wordToNumbers.length() ; i++) {
            char stringToNumbers = wordToNumbers.charAt(i);
            int charIndex = alphabet.indexOf(stringToNumbers) + 1;

            encodedString = encodedString + charIndex + ";";

        }
        return encodedString;
   }
    //This method is to decode an encoded string
    public static String cypherDecoder (String [] numbersInput){
        String decodedString = "";

        for (int i = 0; i < numbersInput.length; i++) {
            String indexAsString = numbersInput[i];
            int stringToInt = Integer.parseInt(indexAsString)-1;

            char indexToCharacter = alphabet.charAt(stringToInt);

            decodedString = decodedString + indexToCharacter ++;

        }
        return decodedString;

    }

    //This method is for encoding a String, the same way Ceasar did
    public static String ceasarEncoder (String ceasarWord){
        int[] wordArray = new int[ceasarWord.length()];
        String encodedString = "";

        for (int i = 0; i < ceasarWord.length(); i++) {
            char wordIndex = ceasarWord.charAt(i);
            int charIndex = charToIndex(wordIndex);

            int charIndexShift = (charIndex + 3) % alphabet.length();
            char encodedChar = numberToChar(charIndexShift);

            encodedString = encodedString + encodedChar;

        } return encodedString;
    }
    //This method is for decoding a String, the same way Ceasar did
    public static String ceasarDecoder (String ceasarDecoderWord){
        int[] wordArray = new int[ceasarDecoderWord.length()];
        String decodedString = "";

        for (int i = 0; i < ceasarDecoderWord.length(); i++) {
            char wordIndex = ceasarDecoderWord.charAt(i);
            int charIndex = charToIndex(wordIndex);

            int charIndexShift = (charIndex - 3) % alphabet.length();
            char decodedChar = numberToChar(charIndexShift);

            decodedString = decodedString + decodedChar;

        } return decodedString;
    }

}
