import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Day6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Inputs/Day6Input.txt"));

        List<String> buffer = new ArrayList<>();
        int idx = 0;
        String[] characters;
        String line;
        while ((line = br.readLine()) != null) {
            characters = line.split("");

            for (String s: characters) {
                buffer.add(s);
                idx++;
                if (buffer.size() > 14) {
                    buffer.remove(0);
                }

                if (buffer.size() == new HashSet<>(buffer).size() && buffer.size() == 14) {
                    break;
                }
            }
        }

        System.out.println(idx);
    }
}
