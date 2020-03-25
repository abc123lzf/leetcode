/**
 * @author lizifan 695199262@qq.com
 * @since 2020.3.2 16:39
 */
public class Offer62 {

    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }

        return res;
    }

}
