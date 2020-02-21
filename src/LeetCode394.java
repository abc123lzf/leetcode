import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.19 18:53
 */
public class LeetCode394 {

    public String decodeString(String s) {
        StringBuilder buf = new StringBuilder(50);
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c) || c == '[') {
                stack.offerFirst(c);
            } else if(c == ']') {
                StringBuilder sb = new StringBuilder();
                StringBuilder number = new StringBuilder();

                boolean contains = false;
                while (!stack.isEmpty()) {
                    Character ch = stack.pollFirst();
                    if(ch == null) {
                        break;
                    } else if(ch == '[') {
                        if(contains) {
                            break;
                        } else {
                            contains = true;
                        }
                    } else if(Character.isDigit(ch)) {
                        number.append(ch);
                    } else {
                        if(contains) {
                            break;
                        } else {
                            sb.append(ch);
                        }
                    }
                }

                sb.reverse();
                number.reverse();
                int count = Integer.parseInt(number.toString());
                if(stack.isEmpty()) {
                    for (int j = 0; j < count; j++) {
                        buf.append(sb);
                    }
                } else {
                    StringBuilder tmp = new StringBuilder();
                    for (int j = 0; j < count; j++) {

                    }
                }

            } else {
                if(stack.isEmpty()) {
                    buf.append(c);
                } else {
                    stack.offerFirst(c);
                }
            }
        }

        return buf.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode394().decodeString("3[a2[c]]"));
    }

}
