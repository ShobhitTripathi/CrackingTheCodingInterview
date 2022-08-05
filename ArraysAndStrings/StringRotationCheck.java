package ArraysAndString;

public class StringRotationCheck {

    public static boolean isSubString(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int firstCharIndex = s2.indexOf(s1.charAt(0));
        System.out.println("index of s1 first character [" + s1.charAt(0) + "] in s2 is: " + firstCharIndex);
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        rotate(str2, str2.length - firstCharIndex);
        System.out.println("String2 after rotation:");
        for (int i = 0;i < str2.length;i++)
            System.out.print(str2[i]);
        System.out.println();
        for (int i = 0; i < str1.length;i++) {
            if (str1[i] != str2[i])
                return false;
        }
        return true;
    }

    public static void rotate (char[] str, int k) {
        if (str == null)
            return;
        int n = str.length -1;
        k %= n;
        reverseString(str, 0, n);
        reverseString(str, 0, k - 1);
        reverseString(str, k , n);
    }

    public static void reverseString(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }

    // Solution 2 : isRotation
    public static boolean isRotation(String s1, String s2) {
      if (s1.length() != s2.length()) {
         return false;
      }
      String s1s1 = s1 + s1;
      System.out.println("s1s1: " + s1s1);
      System.out.println("s2: " + s2);
      return isSubstring(s1s1, s2);
   }
   
   private static boolean isSubstring(String str, String substr) {
      return str.contains(substr);
   }

    /*--------------Driver Code ----------*/
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "rbottlewate";
        System.out.println("String s1 :" + s1);
        System.out.println("String s2 : " + s2);
        System.out.println("Solutio1 : is s2 :" + s2 + " rotation of String s1 : " + s1 + " : " + isSubString(s1, s2));
        System.out.println("Solution2 : is s2 :" + s2 + " rotation of String s1 : " + s1 + " : " + isRotation(s1, s2));
    }
}
