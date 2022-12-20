import java.io.FileReader;
import java.util.Arrays;
import java.io.BufferedReader;


public class Day4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("Inputs/Day4Input.txt"));

        String line;
        String[] strPairs;
        int[] pairs;
        int count1 = 0;
        int count2 = 0;

        while ((line = br.readLine()) != null) {
            strPairs = line.split("[-,]");
            pairs = Arrays.stream(strPairs).mapToInt(Integer::parseInt).toArray();
            
            if ( (pairs[0] <= pairs[2] && pairs[1] >= pairs[3]) || (pairs[2] <= pairs[0] && (pairs[3] >= pairs[1]) ) ) {
                count1++;
            }
            if ( (pairs[0] <= pairs[2] && pairs[1] >= pairs[2]) ||
            (pairs[2] <= pairs[0] && (pairs[3] >= pairs[0]) ) ) {
                count2++;
            }

        }

        System.out.println(count1);
        System.out.println(count2);
    }
}
