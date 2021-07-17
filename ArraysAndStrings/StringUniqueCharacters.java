package ArraysAndString;

import java.util.Arrays;

public class StringUniqueCharacters {

    static boolean hasUniqueCharacters (String S){
        // Assuming string can have characters a-z
        // this has 32 bits set to 0
        int checker = 0;

        for (int i = 0;i < S.length();i++) {
            int bitAtIndex = S.charAt(i) - 'a';

            // if that bit is already set in checker,
            // return false
            if ((checker & (1 << bitAtIndex)) > 0)
                return false;

            // otherwise update and continue by
            // setting that bit in the checker
            checker = checker | (1 << bitAtIndex);
        }
        return true;
    }

    public static final int MAX_CHAR = 256;
    static boolean hasUniqueCharactersWithExtraDS(String str)
    {
        // If length is greater than 256,
        // some characters must have been repeated
        if (str.length() > MAX_CHAR)
            return false;

        boolean[] chars = new boolean[MAX_CHAR];
        Arrays.fill(chars, false);

        for (int i = 0; i < str.length(); i++) {
            int index = (int)str.charAt(i);

            /* If the value is already true, string
               has duplicate characters, return false */
            if (chars[index])
                return false;

            chars[index] = true;
        }

        /* No duplicates encountered, return true */
        return true;
    }

    /*-------------Driver Code -----------*/
    public static void main(String[] args) {
        //i/p: abba  o/p: false
        //ip: abcded o/p: true
        String s = "abcdef";
        System.out.println("String: "+ s);
        System.out.println("hasUniqueCharacters: " + hasUniqueCharacters(s));
        System.out.println("hasUniqueCharactersWithExtraDS: " + hasUniqueCharactersWithExtraDS(s));

    }
}
