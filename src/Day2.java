import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptContext;

import java.util.HashMap;


public class Day2 {
    static final int rock = 1;
    static final int paper = 2;
    static final int scissors = 3;

    static final int win = 6;
    static final int draw = 3;
    static final int lose = 0;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader("Inputs/Day2Input.txt"));

        HashMap<String, Integer> rounds = new HashMap<String, Integer>();
        
        // rounds.put("AX", rock + draw);
        // rounds.put("AY", paper + win);
        // rounds.put("AZ", scissors + lose);
        // rounds.put("BX", rock + lose);
        // rounds.put("BY", paper + draw);
        // rounds.put("BZ", scissors + win);
        // rounds.put("CX", rock + win);
        // rounds.put("CY", paper + lose);
        // rounds.put("CZ", scissors + draw);

        rounds.put("AX", scissors + lose);
        rounds.put("AY", rock + draw);
        rounds.put("AZ", paper + win);
        rounds.put("BX", rock + lose);
        rounds.put("BY", paper + draw);
        rounds.put("BZ", scissors + win);
        rounds.put("CX", paper + lose);
        rounds.put("CY", scissors + draw);
        rounds.put("CZ", rock + win);

        String line;
        String turn;
        int sum = 0;

        while ((line = br.readLine()) != null) {
            turn = "" + line.charAt(0) + line.charAt(2);
            sum += rounds.get(turn);
        }
        br.close();
        System.out.println(sum);
    }
}
