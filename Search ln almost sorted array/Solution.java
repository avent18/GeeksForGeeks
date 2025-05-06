class Solution {
    public int findTarget(int arr[], int target) {
        // code here
         int start = 0;
         int end = arr.length-1;
         
         while(start<=end){
             int mid = start+(end-start)/2;
             if(arr[mid]==target) return mid;
             if(mid > start && arr[mid-1]==target) return mid-1;
             if(mid < end && arr[mid+1]==target) return mid+1;
             
             if(target<arr[mid]){
                 end = mid-1;
             } else {
                 start = mid+1;
             }
         } return -1;
    }
}


