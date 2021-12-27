package TwoPointers;

/**
 * JZ58-1，翻转单词顺序，注意首尾空格和 单词之间的多个空格
 * 测试用例："  hello world!  "，预期结果："world! hello"
 * "a good   example"   ->    "example good a"
 */
public class JZ58_1_ReverseWords {
    public static void main(String[] args) {
        String str = "a good   example ";
//        System.out.println(ReverseSentence(str));
        JZ58_1_ReverseWords test = new JZ58_1_ReverseWords();
//        System.out.println(test.reverseWords(str));
        System.out.println(test.ReverseSentence(str));

    }

    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while (i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }


    public String ReverseSentence(String str) {
        // 删除首尾空格
        str = str.trim();
        int j = str.length() - 1, i = j;
        // 存储结果  StringBuffer是线程安全的，而StringBuilder则没有实现线程安全功能，所以性能略高。
        StringBuilder res = new StringBuilder();

        while (i >= 0) {
            while (i >= 0 && str.charAt(i) != ' ') { // 搜索首个空格, 注意这里是 !=
                i--;
            }
            // 添加单词
            res.append(str.substring(i + 1, j + 1) + " ");
            // 跳过单词间的多个空格
            while (i >= 0 && str.charAt(i) == ' ') {
                i--;
            }
            j = i; // j指向下个单词的尾字符
        }
        return res.toString().trim(); // 转换为 字符串  并返回
    }
}
