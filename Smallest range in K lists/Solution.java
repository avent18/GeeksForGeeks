
class Solution {
    static class Node{
         int val, col, row;
         Node(int val, int row, int col){
             this.val = val;
             this.row = row;
             this.col = col;
         }
    }
    
    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = Integer.MAX_VALUE;
        
        for(int i =0; i<arr.length; i++){
            int val = arr[i][0];
            minHeap.add(new Node(val, i , 0));
            max= Math.max(max, val);
        }
        
        
        while(true){
            Node NewNode = minHeap.poll();
            int min = NewNode.val;
            
            if(max- min  < end-start){
                start = min;
                end = max;
            }
            
          if(NewNode.col+1 < arr[NewNode.row].length){
              int nextVal = arr[NewNode.row][NewNode.col+1];
              minHeap.add(new Node(nextVal, NewNode.row, NewNode.col+1));
              max = Math.max(max, nextVal);
          } else {
              break;
          }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(start);
        result.add(end);
        return result;
        
    }
}