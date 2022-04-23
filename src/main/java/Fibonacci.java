import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("*****" + Fibonacci.class.getName() + "*******");
        Fibonacci fibonacci = new Fibonacci();
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
                if(number>100 || number <0 ) {
                    System.out.println("Not supported. Please enter a whole number between 0 and 100");
                    continue;
                }
                System.out.println(fibonacci.fib(number));
            }catch(Exception e){
                System.out.println("Please enter a Positive Whole number.");
            }

        }

    }

    //Position: 0, 1, 2, 3, 4, 5, 6, 7,  8,  9
    //Result:   0, 1, 1, 2, 3, 5, 8, 13, 21, 34

    private Integer fib(Integer number) {
        if(number<2) return number;
        return fib(number - 1 ) + fib(number - 2);
    }
}
