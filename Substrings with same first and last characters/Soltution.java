import java.util.*;
class Solution {
    public int countSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count =0;
        for(int freq: map.values()){
            count+=(freq*(freq+1))/2;
        }

        return count;
    }
}

