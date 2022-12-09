import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Stack;


public class Day52018 {
    public static void main(String[] args) throws Exception{

    BufferedReader br = new BufferedReader(new FileReader("Inputs/Day52018Input.txt"));
    Stack<String> stack = new Stack<String>();

    String polymer = br.readLine();
    // String[] units = polymer.split("");
    String[] units;

    String curr;
    String prev;
    String alphabet = "abcdefghijklmnopqrstuwxyz";
    String asd;
    String s;
    int min = polymer.length();

    // iterate over alphabet
    for (int j = 0; j < alphabet.length(); j++) {
        s = Character.toString(alphabet.charAt(j));
        asd = polymer.replaceAll(s, "").replaceAll(s.toUpperCase(), "");

        units = asd.split("");
        stack.clear();
        // main job
        for (int i = 0; i < units.length; i++) {
            curr = units[i];

            if (stack.isEmpty()) {
                stack.push(curr);
                continue;
                }
            
            prev = stack.peek();
            
            // a = A and curr is lowercase
            if (curr.toUpperCase().equals(prev) && !Character.isUpperCase(curr.charAt(0))) {
                stack.pop();
                }
            // A = a and prev is lowercase
            else if (curr.equals(prev.toUpperCase()) && !Character.isUpperCase(prev.charAt(0))) {
                stack.pop();
                }
            // if a = a or A = A
            else {
                stack.push(curr);
                }
            }

        min = (min<stack.size()) ? min: stack.size();
        }
        System.out.println(min);
    }
}
