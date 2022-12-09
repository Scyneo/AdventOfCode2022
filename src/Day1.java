import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Day1 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader("Inputs/Day1Input.txt"));

        List<Integer> totals = new ArrayList<Integer>();
        int calories = 0;
        int mostCalories = 0;

        String line;
        while ((line = br.readLine()) != null) {
            String strCal = line.strip();

            if (strCal.isEmpty()) {
                totals.add(calories);
                mostCalories = (mostCalories>calories) ? mostCalories: calories;
                calories = 0;
                continue;
            }
            calories += Integer.parseInt(strCal);
        
        }
        br.close();
        Collections.sort(totals, Collections.reverseOrder());

        System.out.println(mostCalories);
        System.out.println(totals.get(0) + totals.get(1) + totals.get(2));
    }
}
