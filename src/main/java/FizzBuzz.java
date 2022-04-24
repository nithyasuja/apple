import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// --- Directions
// Write a program that console logs the numbers
// from 1 to n. But for multiples of three print
// fizz instead of the number and for the multiples
// of five print buzz. For numbers which are multiples
// of both three and five print fizzbuzz
// --- Example
//   fizzBuzz(5);
//   1
//   2
//   fizz
//   4
//   buzz
public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println("*****Fizzbuzz*****");
        FizzBuzz fizzBuzz = new FizzBuzz();
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter any number, Type Q to Quit: ");

            String input = scan.next();
            if ("Q".equalsIgnoreCase(input)) {
                scan.close();
                System.out.println("Bye....");
                System.exit(0);
            }
            try {
                Integer number = Integer.parseInt(input);
                if(number>100 || number <0 ) System.out.println("Not supported");
                fizzBuzz.determineFizzBuzz(number);
            }catch(Exception e){
                System.out.println("Please enter a Positive Whole number.");
            }

        }

    }

    private void determineFizzBuzz(Integer number) {
        IntStream.range(1, number+1).mapToObj(x -> x%3==0 && x%5==0 ? "fizzbuzz" : x%3==0 ? "fizz" : x%5==0 ? "buzz" : String.valueOf(x)).forEach(System.out::println);
//        if (number%3==0 && number%5==0) return "FizzBuzz";
//        if(number%3==0) return "Fizz";
//        if(number%5==0) return "Buzz";
//        return "None";
    }
}
