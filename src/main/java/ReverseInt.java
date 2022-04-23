import java.util.Arrays;
import java.util.Scanner;

public class ReverseInt {
    // --- Directions
// Given an integer, return an integer that is the reverse
// ordering of numbers.
// --- Examples
//   reverseInt(15) === 51
//   reverseInt(981) === 189
//   reverseInt(500) === 5
//   reverseInt(-15) === -51
//   reverseInt(-90) === -9


    public static void main(String[] args) {
        System.out.println("*****" + ReverseInt.class.getName() + "*******");
        ReverseInt reverseInt = new ReverseInt();
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter an integer to be reversed, Type Q to Quit: ");

            String input = scan.next();
            if ("Q".equalsIgnoreCase(input)) {
                scan.close();
                System.out.println("Bye....");
                System.exit(0);
            }

            try {
                Integer number = Integer.parseInt(input);
                if(number < -1000 || number > 1000) {
                    System.out.println("Not supported");
                    continue;
                }
                System.out.println(reverseInt.getReversedInteger(number));
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Please enter a Whole number.");
            }
        }
    }

    private Integer getReversedInteger(Integer number) {
        Integer absNumber = Math.abs(number);
        String reversedInt = Arrays.asList(absNumber.toString().split("")).stream().reduce("",(reverse, a) -> a + reverse);
        return Integer.valueOf(reversedInt) * Integer.signum(number);
    }

}
