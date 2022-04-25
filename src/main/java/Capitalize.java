import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Capitalize {
    // --- Directions
// Write a function that accepts a string.  The function should
// capitalize the first letter of each word in the string then
// return the capitalized string.
// --- Examples
//   capitalize('a short sentence') --> 'A Short Sentence'
//   capitalize('a lazy fox') --> 'A Lazy Fox'
//   capitalize('look, it is working!') --> 'Look, It Is Working!'

    public static void main(String[] args) {
        System.out.println("*****" + Capitalize.class.getName() + "*******");
        Capitalize capitalize = new Capitalize();
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a sentence with spaces to be capitalized (Camel cased) Type Q to Quit: ");

            String input = scan.nextLine();
            if ("Q".equalsIgnoreCase(input)) {
                scan.close();
                System.out.println("Bye....");
                System.exit(0);
            }
            try {
                capitalize.printCapitalized(input);
            } catch (Exception e) {
                System.out.println("Input issues.");
                e.printStackTrace();
            }
        }
    }

    private void printCapitalized(String input) {
        String[] inputArr = input.split(" ");
        String result = "";
        String delimiter;
        for(int i=0; i<inputArr.length ; i++) {
            String str = inputArr[i];
            String strFirstChar = str.split("")[0].toUpperCase();
            String[] strRest = Arrays.copyOfRange(str.split(""),1,str.length(), String[].class);
            delimiter = (i==0)? "" : " ";
            result = String.join (delimiter, result, strFirstChar+Arrays.asList(strRest).stream().collect(Collectors.joining()));
        }
        System.out.println(result);
    }
}
