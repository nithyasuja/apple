import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Palindrome {
// --- Directions
// Given a string, return true if the string is a palindrome
// or false if it is not.  Palindromes are strings that
// form the same word if it is reversed. *Do* include spaces
// and punctuation in determining if the string is a palindrome.
// --- Examples:
//   palindrome("abba") === true
//   palindrome("abcdefg") === false

    public static void main(String[] args) {
        System.out.println("*****" + Palindrome.class.getName() + "*******");
        Palindrome palindrome = new Palindrome();
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a string to find if its a palindromed, Type Q to Quit: ");

            String input = scan.next();
            if ("Q".equalsIgnoreCase(input)) {
                scan.close();
                System.out.println("Bye....");
                System.exit(0);
            }
            System.out.println(palindrome.isPalindrome(input)?"You entered a palindrome!":"You did not enter a palindrome!");

        }
    }

    private boolean isPalindrome(String str) {
        if(str==null||str.isEmpty()) return false;
//        String reversedString = Arrays.asList(str.split("")).stream().reduce("", (reverse, a) -> a + reverse);
//        if(str.equalsIgnoreCase(reversedString)) return true;
//        return false;

      //this is not the ideal solution as its going to compare two times.
        //the solution above is better but we can show allmatch java8 proficency

        String[] inputStringArray = str.split("");
        int length = inputStringArray.length;
        //nice way to get the indices when traversing thru a stream
        return IntStream.range(0, length).allMatch(i -> inputStringArray[i].equalsIgnoreCase(inputStringArray[length-1-i]));

    }


}
