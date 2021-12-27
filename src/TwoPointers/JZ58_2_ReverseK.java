package TwoPointers;

public class JZ58_2_ReverseK {
    public static void main(String[] args) {
        String s = "cbafedZYX";
        int n = 3;
        System.out.println(reverseLeftWords(s,n));

    }
    public static String reverseLeftWords(String s, int n) {
        // 先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"。
        // 边界条件
        if(n>s.length()) return s;
        // 字符串 -> char数组
        char[] chars = s.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,chars.length - 1);
        reverse(chars,0,chars.length - 1);
        // 字符数组 -> 字符串
        return new String(chars);
    }
    public static void reverse(char[] chars,int i, int j){
        while (i<j){
            swap(chars,i++,j--);
        }
    }
    public static void swap(char[] chars, int i, int j){
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}
