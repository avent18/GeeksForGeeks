package Longest Subarray with Majority Greater than K;

class Solution {
    static int longestSubarray(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        int maxLength = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // Convert array to +1 and -1 based on k
            if (arr[i] > k) {
                prefixSum += 1;
            } else {
                prefixSum -= 1;
            }

            // If prefix sum is positive, the whole subarray from 0 to i is valid
            if (prefixSum > 0) {
                maxLength = i + 1;
            } else {
                // Store the first occurrence of prefix sum
                if (!map.containsKey(prefixSum)) {
                    map.put(prefixSum, i);
                }

                // If prefixSum - 1 is found before, a valid subarray exists
                if (map.containsKey(prefixSum - 1)) {
                    maxLength = Math.max(maxLength, i - map.get(prefixSum - 1));
                }
            }
        }

        return maxLength;
    }
}
