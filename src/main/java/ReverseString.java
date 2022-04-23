import java.util.Scanner;

public class ReverseString {

    // --- Directions
// Given a string, return a new string with the reversed
// order of characters
// --- Examples
//   reverse('apple') === 'leppa'
//   reverse('hello') === 'olleh'
//   reverse('Greetings!') === '!sgniteerG'

    public static void main(String[] args) {
        System.out.println("*****" + ReverseString.class.getName() + "*******");
        ReverseString reverseString = new ReverseString();
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a string to reverse, Type Q to Quit: ");

            String input = scan.next();
            if ("Q".equalsIgnoreCase(input)) {
                scan.close();
                System.out.println("Bye....");
                System.exit(0);
            }

            System.out.println(reverseString.reverse(input));
        }
    }

    private String reverse(String str) {
        String reversedString = "";
        int length = str.length();
        char ch;
        for(int i=0; i<length; i++) {
            ch = str.charAt(i);
            reversedString = ch + reversedString;
        }
        return reversedString;
    }

}
