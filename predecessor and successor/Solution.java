class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node predecessor = null;
        Node successor = null;

        Node current = root;
        while (current != null) {
            if (key < current.data) {
                successor = current;
                current = current.left;
            } else if (key > current.data) {
                predecessor = current;
                current = current.right;
            } else {
                // Key found: now find predecessor and successor
                // Predecessor is rightmost in left subtree
                if (current.left != null) {
                    Node temp = current.left;
                    while (temp.right != null)
                        temp = temp.right;
                    predecessor = temp;
                }
                // Successor is leftmost in right subtree
                if (current.right != null) {
                    Node temp = current.right;
                    while (temp.left != null)
                        temp = temp.left;
                    successor = temp;
                }
                break;
            }
        }

        ArrayList<Node> result = new ArrayList<>();
        result.add(predecessor);
        result.add(successor);
        return result;
    }
}