package ArraysAndString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PermutaionPalindrome {
/**
 Using a Hash Table
Since we know some basic qualities of a palindrome string,
we can count characters to determine if the string is a permutation of a palindrome.
Create an array from string and loop through the array,
either adding the character to the hash table as a key or incrementing the count (value) if it already is in the table.
Characters = key and count = value.
Iterate through the hash table to make sure character counts are all even or at most one value is odd.
**/
    public static boolean canPermutePalindromeSet(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0;i < s.length();i++) {
            if (set.contains(s.charAt(i)))
                set.remove(s.charAt(i));
            else
                set.add(s.charAt(i));
        }

        return set.size() <= 1;
    }
 
    public static boolean checkPermutaionPalindromeMap (String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            map.put(c , map.getOrDefault(c, 0) + 1);
        }

        for (char key : map.keySet()) {
                count += map.get(key) % 2;
        }
        return count <= 1;
    }

    /*-----------------Test code------------*/
    public static void main(String[] args) {
        String s = "tactcoa";
        System.out.println("using HashSet isPermutationPalindrome: " + canPermutePalindromeSet(s));
        System.out.println("using HashMap isPermutationPalindrome" + checkPermutaionPalindromeMap(s));
    }
}
