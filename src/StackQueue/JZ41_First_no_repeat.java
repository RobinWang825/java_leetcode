package StackQueue;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.LinkedList;
import java.util.Queue;

public class JZ41_First_no_repeat {
    public static void main(String[] args) {
        String s = "googl";
        String out = "";
        for (int i = 0; i < s.length(); i++) {
            Insert(s.charAt(i));
        }
        out+=FirstAppearingOnce();
        System.out.println(out);

    }
    private static int[] cnts = new int[128];
    private static Queue<Character> queue = new LinkedList<>();
    public static void Insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        System.out.println(queue);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1)
            queue.poll();
//            ;
    }

    public static char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }

}
