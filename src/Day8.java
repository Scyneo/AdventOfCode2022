import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Day8 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("Inputs/Day8Input.txt"));

        List<int[]> heights = new ArrayList<>();
        String line;
        String[] items;
        while((line = br.readLine()) != null) {
            items = line.split("");
            heights.add(Arrays.stream(items).mapToInt(Integer::parseInt).toArray()); 
        }

        int[][] grid = new int[heights.size()][];
        grid = heights.toArray(grid);

        int count = 0;
        for (int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[i].length; j++) {
                count += visible(grid, i, j) ? 1: 0;
            }
        }
            
        System.out.print(count);

    }


    public static final int north = 0;
    public static final int south = 1;
    public static final int east = 2;
    public static final int west = 3;

    public static boolean visible(int[][] grid, int row, int col) {
        int curr = grid[row][col];
        int largest = -1;

        //north
        for (int i=1; i < row + 1; i++) {
            if (grid[row-i][col] >= curr  && grid[row-i][col] >= largest)
                largest = grid[row-i][col];
        }
        if (largest < curr)
            return true;

        largest = -1;
        // south
        for (int i=1; i < grid.length - row ; i++) {
            if (grid[row+i][col] >= curr && grid[row+i][col] >= largest)
                largest = grid[row+i][col];
        }
        if (largest < curr)
            return true;

        largest = -1;
        // east
        for (int i=1; i < grid[row].length - col ; i++) {
            if (grid[row][col+i] >= curr && grid[row][col+i] >= largest)
                largest = grid[row][col+i];
        }
        if (largest < curr)
            return true;

        largest = -1;
       // west              
        for (int i=1; i < col + 1 ; i++) {
            if (grid[row][col-i] >= curr && grid[row][col-i] >= largest)
                largest = grid[row][col-i];
        }
        if (largest < curr)
            return true;

        return false;
    }
}
