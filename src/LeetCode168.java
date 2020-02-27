/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.22 3:21
 */
public class LeetCode168 {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append((char)(n % 27 + 'A'));
            n /= 26;
        }

        return sb.toString();
    }

}
