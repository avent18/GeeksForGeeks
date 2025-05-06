package Left view of binary tree;

public class Solution {
    ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        leftView(root, 0, res);
        return res;
    }
    
    void leftView(Node node, int level, ArrayList<Integer> res) {
    if (node == null) return;

    if (level == res.size()) {
        res.add(node.data);
    }

    leftView(node.left, level + 1, res);
    leftView(node.right, level + 1, res);
}
}
