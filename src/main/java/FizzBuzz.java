import java.util.Scanner;

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
                System.out.println(fizzBuzz.determineFizzBuzz(number));
            }catch(Exception e){
                System.out.println("Please enter a Positive Whole number.");
            }

        }

    }

    private String determineFizzBuzz(Integer number) {
        if(number>100 || number <0 ) return "Not supported";
        if (number%3==0 && number%5==0) return "FizzBuzz";
        if(number%3==0) return "Fizz";
        if(number%5==0) return "Buzz";
        return "None";
    }
}
