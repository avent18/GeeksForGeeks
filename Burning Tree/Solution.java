class Solution {
    private static void mapParents(Node root, Map<Node, Node>parentMap, int target ,Node[] targetNode ){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr.data == target) targetNode[0]=curr;
            if(curr.left!=null){
                parentMap.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if(curr.right!=null){
                parentMap.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }
    
    public static int minTime(Node root, int target) {
        Map<Node, Node> parentMap = new HashMap<>();
        Node[] targetNode = new Node[1];
        mapParents(root, parentMap, target, targetNode);
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        
        queue.offer(targetNode[0]);
        visited.add(targetNode[0]);
        
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean fireSpread = false;
            
            for(int i = 0; i<size; i++){
                Node curr = queue.poll();
                for(Node nebr: Arrays.asList(curr.left, curr.right, parentMap.get(curr))){
                    if(nebr!=null && !visited.contains(nebr)){
                        visited.add(nebr);
                        queue.offer(nebr);
                        fireSpread = true;
                    }
                }
            }
            if(fireSpread) time++;
            
        }
        return time;
        
    }
}