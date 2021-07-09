package ArraysAndString;

import java.util.Arrays;

public class checkPermutation {

    static boolean checkStrings(String s1, String s2) {
        //base condition
        if (s1.length() != s2.length())
            return false;
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        //count array for String s1
        int[] count1 = new int[256];
        Arrays.fill(count1, 0);
        //count array for String s2
        int[] count2 = new int[256];
        Arrays.fill(count2, 0);

        //incrementing the count array as per characters
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }
        // Compare count arrays
        for (int i = 0; i < 256; i++){
            if (count1[i] != count2[i])
                return false;
        }
        return true;
    }

    
    /*-----------test-------------------------*/
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "dbcz";

        System.out.println(checkStrings(s1,s2));
    }
}
