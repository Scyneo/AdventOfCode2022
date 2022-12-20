import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Stack;


public class Day52018 {
    public static void main(String[] args) throws Exception{

    BufferedReader br = new BufferedReader(new FileReader("Inputs/Day52018Input.txt"));
    Stack<String> stack = new Stack<String>();
    String alphabet = "abcdefghijklmnopqrstuwxyz";
    String polymer = br.readLine();
    
    // String[] units = polymer.split("");
    String[] units;

    String curr;
    String prev;

    String s;
    int min = polymer.length();

    // iterate over alphabet
    for (int j = 0; j < alphabet.length(); j++) {
        s = Character.toString(alphabet.charAt(j));
        units = polymer.replaceAll(s, "").replaceAll(s.toUpperCase(), "").split("");
        stack.clear();
        // main job
        for (int i = 0; i < units.length; i++) {
            curr = units[i];

            if (stack.isEmpty()) {
                stack.push(curr);
                continue;
                }
            
            prev = stack.peek();
            // A != a and a = a -> yes | B != a and b = a -> no 
            if (!curr.equals(prev) && curr.equalsIgnoreCase(prev)) {
                stack.pop();
                }
            // if a = a or b = a
            else {
                stack.push(curr);
                }
            }
        min = Math.min(min, stack.size());
        }
        System.out.println(min);
    }
}
