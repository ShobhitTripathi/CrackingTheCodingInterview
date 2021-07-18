package ArraysAndString;

public class urlify {

    // Time: O(n), Space: O(1)
    private static void replaceSpaces(char[] toBeTransformed, int currLength) {
        int j = toBeTransformed.length - 1;

        for (int i = currLength - 1; i >= 0 && i < j; --i) {
            if (toBeTransformed[i] == ' ') {
                toBeTransformed[j--] = '0';
                toBeTransformed[j--] = '2';
                toBeTransformed[j--] = '%';
            } else {
                toBeTransformed[j--] = toBeTransformed[i];
            }
        }
    }

    static String replaceUsingStringBuilder (String s) {
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < s.length();i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main (String[] args) {
//        String S = "Mr John Smith    ";
//        System.out.println("new String: " + replaceUsingStringBuilder(S));
        String s = "Mr John Smith";
        String extraSpaces = "    ";
        char[] toBeTransformed = (s + extraSpaces).toCharArray();

        replaceSpaces(toBeTransformed, s.length());

        System.out.println(new String(toBeTransformed));
    }

}
