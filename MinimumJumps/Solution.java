package MinimumJumps;

public class Solution {
    

        public static int minJumps(int[] arr) {
            int n = arr.length;
    
            if (n <= 1) return 0;       // No jumps needed if at the end
            if (arr[0] == 0) return -1; // Cannot move anywhere
    
            int maxReach = arr[0];
            int steps = arr[0];
            int jumps = 1;
    
            for (int i = 1; i < n; i++) {
                if (i == n - 1) return jumps; // Reached end
    
                maxReach = Math.max(maxReach, i + arr[i]);
                steps--;
    
                if (steps == 0) {
                    jumps++;
    
                    if (i >= maxReach) return -1; // Cannot move further
    
                    steps = maxReach - i;
                }
            }
    
            return -1; // Default case: end not reached
        }
    
        // Example usage
        public static void main(String[] args) {
            Solution solver = new Solution();
    
            int[] arr1 = {2, 3, 1, 1, 4};
            int[] arr2 = {1, 0, 3, 2, 1};
    
            System.out.println(solver.minJumps(arr1)); // Output: 2
            System.out.println(solver.minJumps(arr2)); // Output: -1
        }
    }
    

