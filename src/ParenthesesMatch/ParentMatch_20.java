package ParenthesesMatch;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class ParentMatch_20 {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
//        ParentMatch_20 test = new ParentMatch_20();
//        System.out.println(test.isValid(s));


    }
    public static boolean isValid(String s){
        int n = s.length();
        if(n%2!=0) return false;

        // 定义并初始化map
        HashMap<Character, Character> pairs = new HashMap<Character,Character>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Object> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);//返回字符串指定索引处的 char 值。
            if (pairs.containsKey(ch)){
                //get 返回指定键所映射的值
                // E peek() // 返回栈顶的元素, 如果列表为空，返回null
                if (stack.isEmpty() || stack.peek()!=pairs.get(ch)){
                    return false;
                }
                stack.pop();
            }
            // 压栈 如果不加else 会错，因为执行完上面的if就会走到这里
            else{
                stack.push(ch);
            }

        }
        return stack.isEmpty();


    }
}
