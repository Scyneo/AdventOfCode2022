import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Stack;
import java.util.Arrays;
import java.util.HashMap;
import java.lang.StringBuilder;
import java.util.ArrayList;


public class Day5 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader("Inputs/Day5Input.txt"));
        StringBuilder sb = new StringBuilder();

        HashMap<String, Stack<String>> stacks = new HashMap<String, Stack<String>>();
        Stack<String[]> lines = new Stack<String[]>();

        // Create stacks
        for (int i = 1; i < 10; i++) {
            stacks.put(Integer.toString(i), new Stack<>());
        }
        // Fill stack with crates
        String line;
        while (!"".equals((line = br.readLine()))) {
            lines.push(line.split(""));
        }
        // Pop first useless line
        lines.pop();

        String[] asd;
        int linesSize = lines.size();
        int currStack;
        for (int j = 0; j < linesSize; j++) {
            asd = lines.pop();
            currStack = 1;
            for (int i = 0; i < asd.length;i++) {
                if ("[".equals(asd[i])) {
                    stacks.get(Integer.toString(currStack)).push(asd[i] + asd[i+1] + asd[i+2]);
                    i += 3;
                    currStack++;
                }
                else if (" ".equals(asd[i])) {
                    i += 3;
                    currStack++;
                }
            }
        }
        String[] box;
        while ((line = br.readLine()) != null) {
            asd = line.split(" ");
            box = new String[Integer.parseInt(asd[1])];

            for (int k = 0; k < Integer.parseInt(asd[1]); k++) {
                box[k] = stacks.get(asd[3]).pop();
            }
            // Reverse box
            for (int j = box.length - 1; j >= 0; j--) {
                stacks.get(asd[5]).push(box[j]);
            }
        }

        stacks.forEach((key, value)-> sb.append(value.pop().charAt(1)));
        System.out.println(sb.toString());
        
    }
}
