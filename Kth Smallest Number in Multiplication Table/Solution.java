class Solution {
    
  
    public int kthSmallest(int m, int n, int k) {
        int start = 1;
        int end = m*n;
     
        
        while(start<=end){
            int mid = start+(end-start)/2;
            int count = 0;
            for(int i =1; i<=m; i++){
                count+=Math.min(mid/i,n);//count the numbers <=i mid in the row i
            }
            if(count<k){
                start= mid+1;
            } else {
                end = mid-1;
            }
            
         }
         return start;
    }
        
}
