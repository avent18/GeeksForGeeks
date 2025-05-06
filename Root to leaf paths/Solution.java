package Root to leaf paths;

    class Solution {
        public static ArrayList<ArrayList<Integer>> Paths(Node root) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            helper(root, new ArrayList<>(), ans);
            return ans;
        }
        public static void helper(Node root, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> ans) {
            if (root == null) return;
    
            // Add current node to the path
            currentPath.add(root.data);
    
            // If it's a leaf node, add a copy of the path to the answer
            if (root.left == null && root.right == null) {
                ans.add(new ArrayList<>(currentPath)); // add copy of current path
            } else {
                // Continue to left and right child
                helper(root.left, currentPath, ans);
                helper(root.right, currentPath, ans);
            }
    
            // Backtrack: remove the current node before returning to the caller
            currentPath.remove(currentPath.size() - 1);
        
    }
}
