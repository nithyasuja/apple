import java.util.Scanner;

public class Steps {
    // --- Directions
// Write a function that accepts a positive number N.
// The function should console log a step shape
// with N levels using the # character.  Make sure the
// step has spaces on the right hand side!
// --- Examples
//   steps(2)
//       '# '
//       '##'
//   steps(3)
//       '#  '
//       '## '
//       '###'
//   steps(4)
//       '#   '
//       '##  '
//       '### '
//       '####'


    public static void main(String[] args) {
        System.out.println("*****" + Steps.class.getName() + "*******");
        Steps steps = new Steps();
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
                steps.printSteps(number);
                steps.printStepsRowColumnStairs(number);
            }catch(Exception e){
                System.out.println("Please enter a Positive Whole number.");
            }

        }
    }

    private void printSteps(Integer number) {
        for(int i =1; i<=number; i++) {
            String rowPatterns = "";
            String rowSpaces = "";
            for(int j = 1; j<=i; j++ ){
                rowPatterns = rowPatterns + "#";
            }
            for(int j = i+1; j<=number; j++ ){
                rowSpaces = rowSpaces + " ";
            }
            System.out.println(rowPatterns+rowSpaces);
        }
    }

    private void printStepsRowColumnStairs(Integer number) {
         for(int i = 1; i<=number; i++) {
             String stair = "";
             for(int j=1; j<=number; j++) {
                 if(j<=i) {
                     stair = stair + "#";
                 }else{
                     stair = stair + " ";
                 }
             }
             System.out.println(stair);
         }
    }
}
