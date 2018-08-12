// From hackerrank Cracking the Coding interview ConnectedCell

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static HashMap<Integer, Integer> visited = new HashMap<>(); 
    static int row_length;
    static int col_length; 
    static int[][] grid; 

    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
        int result = 0;
        result = walkGrid(grid);
        //int result = findRegions();
        return result;
    }
    
     static int walkGrid(int[][] gridIn) {
       // walk the grid,  if the node is a 1 do a DFS on its nieghbors and put a region identifier  
        // in the visited map. Do this until all the nodes have been visited. 
        // Once done, count the number of nodes in each region and find the largest
        row_length = gridIn.length;
        col_length = gridIn[0].length; 
        int count = 0; 
        grid = gridIn; 
        int lastBestCount  = 0; 
        for (int i=0; i<row_length; i++) {
            for (int j=0; j<col_length; j++) {
                count = doCount(i, j);
                lastBestCount=Math.max(count, lastBestCount); 
            }
        } 
         
        return lastBestCount; 
     }
    
    static int doCount(int i, int j) {
        int count = 0; 
        if (!inBounds(i,j)) { 
            return count;
        } else {
            if (grid [i][j] == 0) {
                return 0; 
            }
            if (grid[i][j] == 1) {
                count++;
                grid[i][j] = 0;  
            }
            
            count += doCount(i-1, j-1);
            count += doCount(i-1, j);
            count += doCount(i-1, j+1);
            count += doCount(i, j-1);
            count += doCount(i, j+1);
            count += doCount(i+1, j-1);
            count += doCount(i+1, j);
            count += doCount(i+1, j+1); 
            return count;  
        }
    }
    
    static boolean inBounds(int i, int j) {
        if  ((i < 0) || (i>=row_length) || (j<0) || (j>=col_length)) {
            return false;
        } else {
            return true; 
        }
    }
    
  /* 
    static int findRegions() {
        HashMap<Integer, Integer> countMap = new HashMap<>(); 
        Collection<Integer> values = visited.values();
        
        for (Integer value: values) {
            Integer count = countMap.get(value);
            
            if (count == null) {
                countMap.put(value, 1);
            } else {
                System.out.println(count++);
                countMap.put(value, (count++));
            }
        }
        
        Integer max = 0;
        
        Collection<Integer> counts = countMap.values(); 
        for (Integer count: counts) {
            if (count > max) {
                max = count; 
            }
        }
        return (int) max.intValue(); 
    }
    
    static int walkGrid(int[][] grid) {
       // walk the grid,  if the node is a 1 do a DFS on its nieghbors and put a region identifier  
        // in the visited map. Do this until all the nodes have been visited. 
        // Once done, count the number of nodes in each region and find the largest
        row_length = grid.length;
        col_length = grid[0].length; 
        int region = 1; // different than 0 
        
        for (int i=0; i<row_length; i++) {
            for (int j=0; j<col_length; j++) {
                int id = getID(i,j);
                System.out.println("id:" + id);
                Integer value = visited.get(id); 
                if (visited.get(id) != null) {  
                    // add to visited
 
                    // Add to region 0
                    if (grid[i][j] == 0) {
                        visited.put(id, 0);
                     } else if (grid[i][j] == 1) {
                        region++; 
                        System.out.println(region);
                        doDFS(i, j, grid, region); 
                    } else {
                        // Should not get here
                        System.err.println("error: grid value wrong");
                        return 0; // as cheap error condition
                    }
                       
                } else {
                    continue;  // we've already been here
                }
            }
        }
        return 0;
    }
    
    
    // Check the neighbors in 8 directions, any that are also a 1 and not visited
    // should get the region set. 
    public static void doDFS(int i, int j, int[][] grid,  int region) {
        for (int ii=-1; ii<=1; ii++) {
            for (int jj=-1; jj<=1; jj++) {
                int new_i = i + ii;
                int new_j = j + jj;
                if ((new_i < 0) || (new_i>row_length)) {
                    // no good
                    return; 
                } 
                 if ((new_j< 0) || (new_i>row_length)) {
                    // no good
                    return; 
                } 
                // got here, so in bounds
                if (visited.get(getID(ii,jj)) == null) {
                    if (grid[ii][jj] == 0) {
                        visited.put(getID(ii,jj), 0);
                     } else if (grid[ii][jj] == 1) { 
                        doDFS(ii, jj, grid, region); 
                    } else {
                        // Should not get here
                        return; // as cheap error condition
                    }
                } else { // already been here
                    return; 
                }
                return; 
            }
            return; 
        }
        return;        
    }
                    
    private static int getID(int i, int j)  {
        int id = i*col_length + j; 
        return id; 
    }
*/
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
