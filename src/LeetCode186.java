/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.22 2:37
 */
public class LeetCode186 {

    public void reverseWords(char[] s) {
        int len = s.length;
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            swap(s, i, j);
        }

        int i = 0;
        while (i < len) {
            int j = i;
            while (j < len) {
                if(s[j] == ' ') {
                    break;
                }
                j++;
            }

            for (int l = i, r = j - 1; l < r; l++, r--) {
                swap(s, l, r);
            }

            i = j + 1;
        }
    }

    private static void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }

}
