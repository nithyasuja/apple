import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChunkUsingLists {

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
        System.out.println("*****" + ChunkUsingLists.class.getName() + "*******");
        ChunkUsingLists chunk = new ChunkUsingLists();
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
                chunk.chunkArray(numberlist, chunkSize);
                chunk.chunkArrayByCopying(numberlist, chunkSize);
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Please enter whole numbers.");
            }

        }

    }

    private void chunkArray(List<Integer> numArray, int chunkSize) {
        List<List<Integer>> chunkedList = new ArrayList<>();
        for(Integer num: numArray) {
           if(chunkedList.size() == 0 || chunkedList.get(chunkedList.size()-1).size() == chunkSize){
               chunkedList.add(new ArrayList<>());
           }
           chunkedList.get(chunkedList.size()-1).add(num);
        }
        System.out.println(chunkedList);
    }

    private void chunkArrayByCopying(List<Integer> numArray, int chunkSize) {
        List<List<Integer>> chunkedList = new ArrayList<>();
        int numberOfSubArrays = (int) Math.ceil((double)numArray.size()/chunkSize);
        for(int i=0; i < numberOfSubArrays; i++){
            int from = i * chunkSize;
            int to = from +chunkSize > numArray.size()-1? numArray.size() : from +chunkSize;
            Integer[] subArray = Arrays.copyOfRange(numArray.toArray(), from, to, Integer[].class);
            chunkedList.add(Arrays.asList(subArray));
        }
        System.out.println(chunkedList);
    }
}
