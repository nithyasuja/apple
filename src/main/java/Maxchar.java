import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Maxchar {
    // --- Directions
// Given a string, return the character that is most
// commonly used in the string.
// --- Examples
// maxChar("abcccccccd") === "c"
// maxChar("apple 1231111") === "1"

    public static void main(String[] args) {
        System.out.println("*****" + Maxchar.class.getName() + "*******");
        Maxchar maxchar = new Maxchar();
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a string for which max char has to be found, Type Q to Quit: ");
            String input =  scan.nextLine();

            if ("Q".equalsIgnoreCase(input)) {
                scan.close();
                System.out.println("Bye....");
                System.exit(0);
            }
            try {
                System.out.println("Maxchar is " + maxchar.getMaxChar(input));
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Please enter a Whole number.");
            }
        }
    }

    private String getMaxChar(String input) {
        String maxChar = "";
        long count = 0;
        long occurence = 0;
        String[] inputArray = input.split("");
        List<String> inputList = Arrays.asList(inputArray);

        for(String ch: inputArray) {
            count = Arrays.asList(inputArray).stream().filter(a -> a.equalsIgnoreCase(ch)).count();
            if( count > occurence ) {
                occurence = count;
                maxChar  = ch;
            }
        }

        Map<String, Long> charOccurenceCountMap = inputList.stream().collect(Collectors.toMap(a -> a, a-> inputList.stream().filter(b -> b.equalsIgnoreCase(a)).count(), (a,b) -> a));

        System.out.println(charOccurenceCountMap);
        String key = Collections.max(charOccurenceCountMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println("MaxChar from map is "+ key);

        return maxChar;
    }
}
