class Solution {
    public int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public void leftToRight(Node root, int level, List<Integer> res) {
        if (root == null) return;
        if (level == 0) {
            res.add(root.data);
            return;
        }
        leftToRight(root.left, level - 1, res);
        leftToRight(root.right, level - 1, res);
    }
    public void rightToLeft(Node root, int level, List<Integer> res) {
        if (root == null) return;
        if (level == 0) {
            res.add(root.data);
            return;
        }
        rightToLeft(root.right, level - 1, res);
        rightToLeft(root.left, level - 1, res);
    }
    public ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        int h = height(root);

        for (int level = 0; level < h; level++) {
            List<Integer> levelNodes = new ArrayList<>();
            if (level % 2 == 0) {
                // even level -> right to left
                rightToLeft(root, level, levelNodes);
            } else {
                // odd level -> left to right
                leftToRight(root, level, levelNodes);
            }
            result.addAll(levelNodes);
        }

        return result;
    }
}