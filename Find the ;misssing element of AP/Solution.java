

// User function Template for Java

class Solution {
    public int findMissing(int[] arr) {
        int n = arr.length;
        int diff = (arr[1] - arr[0] == arr[n-1] - arr[n-2]) ? arr[1] - arr[0] : 
          ((arr[1] - arr[0] == (arr[n-1] - arr[0])/n) ? arr[1] - arr[0] : 
           arr[n-1] - arr[n-2]);
        if (diff == 0) return arr[0];
        
        int res = findMissingUtil(arr, 0, n - 1, diff);
        return (res == Integer.MAX_VALUE)?(arr[0] + (n)*diff):res;
        
       
        
        
    }
    static int findMissingUtil(int[]arr, int start , int end, int diff){
        if(end<=start) return Integer.MAX_VALUE;
        
        int mid = start+(end-start)/2;
        if(arr[mid+1]-arr[mid]!=diff) return arr[mid]+diff;
        if(mid>0 && arr[mid]-arr[mid-1]!=diff) return arr[mid-1]+diff;
        if (arr[mid] == arr[0] + mid * diff) return findMissingUtil(arr, mid + 1, end, diff);
        return findMissingUtil(arr, start , mid - 1, diff);
    }
}
