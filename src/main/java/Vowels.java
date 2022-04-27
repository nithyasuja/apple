import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Vowels {
    // --- Directions
// Write a function that returns the number of vowels
// used in a string.  Vowels are the characters 'a', 'e'
// 'i', 'o', and 'u'.
// --- Examples
//   vowels('Hi There!') --> 3
//   vowels('Why do you ask?') --> 4
//   vowels('Why?') --> 0

    public static void main(String[] args) {
        System.out.println("*****" + Vowels.class.getName() + "*******");
        Vowels vowels = new Vowels();
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a sentence with spaces to get the count of vowels Type Q to Quit: ");

            String input = scan.nextLine();
            if ("Q".equalsIgnoreCase(input)) {
                scan.close();
                System.out.println("Bye....");
                System.exit(0);
            }
            try {
                vowels.getNumberOfVowels(input);
                vowels.getNumberOfVowelsUsingRegex(input);
            } catch (Exception e) {
                System.out.println("Input issues.");
                e.printStackTrace();
            }
        }
    }

    private void getNumberOfVowels(String input) {
        String [] vowels = {"a","e","i","o","u"};
        List<String> vowelsList = Arrays.asList(vowels);
        int count = 0;
        for(String ch: input.split("")) {
            if(vowelsList.contains(ch.toLowerCase())) {
                count++;
            }
        }
        System.out.println("Number of Vowels = "+count);
    }

    private void getNumberOfVowelsUsingRegex(String input) {
        int count = 0;
        for(String ch: input.split("")) {
            if(ch.matches("[aeiou]")) count++;
        }
        System.out.println("Number of Vowels = "+count);
    }
}
