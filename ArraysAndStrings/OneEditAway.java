package ArraysAndString;

public class OneEditAway {
/**
 * Let the input strings be s1 and s2 and lengths of input
 strings be m and n respectively.

 1) If difference between m an n is more than 1,
 return false.
 2) Initialize count of edits as 0.
 3) Start traversing both strings from first character.
 a) If current characters don't match, then
 (i)   Increment count of edits
 (ii)  If count becomes more than 1, return false
 (iii) If length of one string is more, then only
 possible  edit is to remove a character.
 Therefore, move ahead in larger string.
 (iv)  If length is same, then only possible edit
 is to  change a character. Therefore, move
 ahead in both strings.
 b) Else, move ahead in both strings.
 **/

    static boolean isOneEditAway(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int i = 0, j = 0;
        int count = 0;

        if (Math.abs(m - n) > 1)
            return false;

        while (i < m && j < n)  {
            if (s1.charAt(i) != s2.charAt(j)) {
                count++;
                if (count == 1)
                    return false;
                if (m > n)
                    i++;
                else if (m < n)
                    j++;
                else {
                    i++;
                    j++;
                }

            }
            // If current characters match
            else {
                i++;
                j++;
            }
        }

        // If last character is extra
        // in any string
        if (i < m || j < n)
            count++;

        return count == 1;

    }

    /*---------------Test-------------------*/
    public static void main (String[] args) {
        String s1 = "hellw";
        String s2 = "helloo";
        System.out.println("String s1 :" + s1);
        System.out.println("String s2 : " + s2);
        System.out.println("is String s1 :" + s1 + " one edit away from String s2: " + s2 + " : " + isOneEditAway(s1, s2));
    }
}
