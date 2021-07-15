package ArraysAndString;

class test {
    int len;
    char[] arr;

    test(int len, char[] arr) {
        this.len = len;
        this.arr = arr;
    }
}

public class StringCompression {

    public static  test compress(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar) {
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
        }
        test obj = new test (indexAns, chars);
        return obj;
    }

    /*----------Driver Code--------------*/
    public static void main(String[] args) {
        String s = "aabcccccaaa";
        //o/p : a2bc5a3

        test test = compress(s.toCharArray());
        int len = test.len;
        char[] arr = test.arr;
        for (int i = 0; i < len;i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
