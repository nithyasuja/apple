import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagrams {
    // --- Directions
// Check to see if two provided strings are anagrams of eachother.
// One string is an anagram of another if it uses the same characters
// in the same quantity. Only consider characters, not spaces
// or punctuation.  Consider capital letters to be the same as lower case
// --- Examples
//   anagrams('rail safety', 'fairy tales') --> True
//   anagrams('RAIL! SAFETY!', 'fairy tales') --> True
//   anagrams('Hi there', 'Bye there') --> False

    public static void main(String[] args) {
        System.out.println("*****" + Anagrams.class.getName() + "*******");
        Anagrams anagrams = new Anagrams();
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter two comma separated string to check if they are anagrams Type Q to Quit: ");

            String input = scan.nextLine();
            if ("Q".equalsIgnoreCase(input)) {
                scan.close();
                System.out.println("Bye....");
                System.exit(0);
            }
            try {
                String[] inputs = input.split(",");
                if (inputs.length != 2) {
                    System.out.println("Please enter only two strings separated by comma");
                    System.exit(0);
                }
                anagrams.isAnagram(inputs[0], inputs[1]);
                anagrams.isAnagramUsingSort(inputs[0], inputs[1]);
            } catch (Exception e) {
                System.out.println("Input issues.");
                e.printStackTrace();
            }
        }
    }

    private void isAnagram(String inputOne, String inputTwo) {
        String cleanOne = inputOne.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String cleanTwo = inputTwo.replaceAll("[^a-zA-Z]", "").toLowerCase();
        if (cleanOne.length() != cleanTwo.length()) {
            System.out.println("The provided strings are not anagrams.");
            return;
        }

        Map<String, Long> charToCountMapOne = Arrays.asList(cleanOne.split("")).stream().collect(Collectors.toMap(x -> x, x -> Arrays.asList(cleanOne.split("")).stream().filter(y -> y.equals(x)).count(), (a, b) -> a));
        Map<String, Long> charToCountMapTwo = Arrays.asList(cleanTwo.split("")).stream().collect(Collectors.toMap(x -> x, x -> Arrays.asList(cleanTwo.split("")).stream().filter(y -> y.equals(x)).count(), (a, b) -> a));
        if (charToCountMapOne.equals(charToCountMapTwo)) {
            System.out.println("The provided strings are anagrams");
        } else {
            System.out.println("The provided strings are not anagrams.");
        }
    }

    private void isAnagramUsingSort(String inputOne, String inputTwo) {
        List<String> cleanOne = Arrays.asList(inputOne.replaceAll("[^a-zA-Z]", "").toLowerCase().split(""));
        List<String> cleanTwo = Arrays.asList(inputTwo.replaceAll("[^a-zA-Z]", "").toLowerCase().split(""));
        Collections.sort(cleanOne);
        Collections.sort(cleanTwo);
        System.out.println(cleanOne+" "+cleanTwo);
        System.out.println(cleanOne.equals(cleanTwo));

    }
}
