import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Chunk {

    // --- Directions
// Given an array and chunk size, divide the array into many subarrays
// where each subarray is of length size
// --- Examples
// chunk([1, 2, 3, 4], 2) --> [[ 1, 2], [3, 4]]
// chunk([1, 2, 3, 4, 5], 2) --> [[ 1, 2], [3, 4], [5]]
// chunk([1, 2, 3, 4, 5, 6, 7, 8], 3) --> [[ 1, 2, 3], [4, 5, 6], [7, 8]]
// chunk([1, 2, 3, 4, 5], 4) --> [[ 1, 2, 3, 4], [5]]
// chunk([1, 2, 3, 4, 5], 10) --> [[ 1, 2, 3, 4, 5]]

    public static void main(String[] args) {
        System.out.println("*****" + Chunk.class.getName() + "*******");
        Chunk chunk = new Chunk();
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a series of comma separated numbers to be chunked, last number is the chunk size, Type Q to Quit: ");

            String input = scan.next();
            if ("Q".equalsIgnoreCase(input)) {
                scan.close();
                System.out.println("Bye....");
                System.exit(0);
            }
            try {
                String[] numbers = input.split(",");
                List<Integer> numberlist = Arrays.asList(numbers).stream().map(a -> Integer.parseInt(a)).collect(Collectors.toList());
                int chunkSize = numberlist.get(numberlist.size()-1);
                numberlist.remove(numberlist.size()-1);

               chunk.chunkArray(numberlist.toArray(new Integer[0]), chunkSize);
            }catch(Exception e){
                System.out.println("Please enter whole numbers.");
            }

        }

    }

    private void chunkArray(Integer[] numArray, int chunkSize) {
        // chunk([1, 2, 3, 4], 2) --> [[ 1, 2], [3, 4]]
        System.out.println(Arrays.toString(numArray));
        Integer[] subArray = null;
        int numberOfSubArrays = (int) Math.ceil((double)numArray.length / chunkSize);
        System.out.println("number of subarrays "+numberOfSubArrays);
        Integer[][] matrixArray = new Integer[numberOfSubArrays][chunkSize];
        for (int j = 0, k=0; k < numberOfSubArrays; k++) {
            subArray = new Integer[chunkSize];
            for (int i = 0; i < chunkSize; i++) {
                System.out.println("j = "+j);
                if ((i+j) > (numArray.length-1)) continue;
                System.out.println(numArray[i+j]);
                subArray[i] = numArray[i+j];
            }
            System.out.println(Arrays.toString(subArray));
            matrixArray[k] = subArray;
            j += chunkSize;
        }
        System.out.println(Arrays.deepToString(matrixArray));

    }
}
