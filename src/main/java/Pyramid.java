import java.util.Scanner;

public class Pyramid {
    // --- Directions
// Write a function that accepts a positive number N.
// The function should console log a pyramid shape
// with N levels using the # character.  Make sure the
// pyramid has spaces on both the left *and* right hand sides
// --- Examples
//   pyramid(1)
//       '#'
//   pyramid(2)
//       ' # '
//       '###'
//   pyramid(3)
//       '  #  '
//       ' ### '
//       '#####'

    public static void main(String[] args) {
        System.out.println("*****" + Pyramid.class.getName() + "*******");
        Pyramid pyramid = new Pyramid();
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
                pyramid.printStepsRowColumnStairs(number);
            }catch(Exception e){
                System.out.println("Please enter a Positive Whole number.");
            }

        }
    }

    private void printStepsRowColumnStairs(Integer number) {
        int numberOfColumns = number*2 -1;
        for(int i =1; i<=number; i++) {
            String stair = "";
            int numberOfHashes = i*2 -1;
            //row 2, total 5, 3 hashes, 9 total columns , start = ((9 -3) /2 )+1, end (9-3)/2 +3
            //row 3, total 5, 5 hashes, 9 columns, start = ((9-5)/2 )+ 1  end ((9-5)/2) + 5
            int startOfHash = (int) Math.ceil((double)(numberOfColumns - numberOfHashes)/2) +1;
            int endOfHash = (int) Math.ceil((double)(numberOfColumns - numberOfHashes)/2) + numberOfHashes;

            for(int j = 1; j <= numberOfColumns ; j++) {
                if(j>=startOfHash && j<=endOfHash) {
                    stair = stair + "#";
                }else {
                    stair = stair + " ";
                }
            }
            System.out.println(stair);
        }


    }
}
