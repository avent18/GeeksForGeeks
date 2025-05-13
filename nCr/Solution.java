package nCr;

class Solution {
    public long nCr(int n, int r) {
        if(r>n) return 0;
        return factorial(n)/(factorial(r)*factorial(n-r));
        
    }
    private long factorial(int x){
        int fact = 1;
        for(int i = 2; i<=x; i++){
            fact = fact*i;
        }
        
        return fact;
    }
}
  
// Another approach

// class Solution {
//     public int nCr(int n, int r) {
//         if(r>n) return 0;
//         if(r>n-r)r = n-r;
//         long result  = 1;
//         for(int i = 1; i<=r; i++){
//             result = result*(n-i+1)/i;
//         }
        
//         return (int)result;
        
//     }
    
// }
