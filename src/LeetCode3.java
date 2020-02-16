import java.util.Arrays;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.16 20:35
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int[] map = new int[255];
        Arrays.fill(map, -1);

        int ans = 0;
        int l = 0, r = 1;

        while (l < len) {
            if(l == r) {
                r++;
            }
            char cl = s.charAt(l);
            map[cl] = l;

            while (r < len) {
                char cr = s.charAt(r);
                if(map[cr] != -1) {
                    ans = Math.max(ans, r - l);
                    for (int i = l; i < map[cr]; i++) {
                        map[s.charAt(i)] = -1;
                    }
                    l = map[cr];
                    map[cr] = -1;
                    break;
                } else {
                    map[cr] = r;
                }
                r++;
            }

            if(r == len) {
                ans = Math.max(ans, r - l);
                break;
            }

            l++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode3().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LeetCode3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LeetCode3().lengthOfLongestSubstring("pwwkew"));
    }

}
