https://www.geeksforgeeks.org/problems/sort-the-given-array-after-applying-the-given-equation0304/1



// Given an integer array arr[] sorted in ascending order, along with three integers: A, B, and C.
//  The task is to transform each element x in the array using the quadratic function A*(x2) + B*x + C.
//  After applying this transformation to every element, return the modified array in sorted order.


class Solution {
    sortArray(arr, A, B, C) {
        return arr.map(num => A * num * num + B * num + C).sort((a,b)=>a-b);
        
    }
}