import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;


public class Day3 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("Inputs/Day3Input.txt"));

        // String left;
        // String right;
        // int cutoff;
        String[] substring;

        int sum = 0;
        char ch;
        ArrayList<String> group = new ArrayList<String>(3);

        String line;
        while ((line = br.readLine()) != null) {
            group.add(line);
            if (group.size() != 3) 
                continue;
            // cutoff = line.length() / 2;
            // left = line.substring(0, cutoff);
            // right = line.substring(cutoff);

            // substring = left.split("");
            substring = group.get(0).split("");
            for (String letter: substring) {
                // if (!right.contains(letter)) {
                //     continue;
                if (!group.get(1).contains(letter) || !group.get(2).contains(letter))
                    continue;

                ch = letter.charAt(0);
                if (Character.isUpperCase(ch))
                    sum += ch - 38;
                else
                    sum += ch - 96;
                break;
                }
                
                group.clear();
            }

            br.close();
            System.out.println(sum);
        }
    }