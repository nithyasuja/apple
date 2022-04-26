import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        System.out.println("*****" + Recursion.class.getName() + "*******");
        Recursion recursion = new Recursion();
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter any positive whole number, Type Q to Quit: ");

            String input = scan.nextLine();
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
                recursion.doRecursion(number);
                recursion.stepsWithRecursionWithoutForLoop(number,1, "");
            }catch(Exception e){
                System.out.println("Please enter a Positive Whole number.");
            }

        }

    }

    private void doRecursion(Integer number) {
        if(number == 0) {
            return;
        }
        System.out.println(number);
        doRecursion(number - 1);
    }


    private void stepsWithRecursion(int total, int numberOfHash) {
        if(numberOfHash > total) {
            return;
        }
        String stair ="";
        for(int i=1; i<=total; i++) {
            if(i<=numberOfHash) {
                stair = stair + "#";
            }else {
                stair = stair + " ";
            }
        }
        System.out.println(stair);
        numberOfHash++;
        stepsWithRecursion(total, numberOfHash);

    }

    private void stepsWithRecursionWithoutForLoop(int total, int row, String stair) {
        if(row > total) {
            return;
        }
        if(stair.length()==total) {
            System.out.println(stair);
            row++;
            stepsWithRecursionWithoutForLoop(total, row, "");
            return; //***** make sure there is a return ******
        }
        if(stair.length() < row){
            stair = stair + "#";
        }else {
            stair = stair + " ";
        }
        stepsWithRecursionWithoutForLoop(total, row, stair);
    }

}
