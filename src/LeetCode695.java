/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.18 1:12
 */
public class LeetCode695 {
    public int maxAreaOfIsland(int[][] map) {
        int h = map.length;
        if(h == 0) {
            return 0;
        }
        int w = map[0].length;

        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(map[i][j] == 1) {
                    ans = Math.max(ans, dfs(map, i, j));
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] map, int i, int j) {
        if(map[i][j] == 1) {
            map[i][j] = 2;
        } else if(map[i][j] == 0 || map[i][j] == 2) {
            return 0;
        }

        int h = map.length;
        int w = map[0].length;

        int a = 0, b = 0, c = 0, d = 0;
        if (j > 0) {
            a = dfs(map, i, j - 1);
        }

        if (j < w - 1) {
            b = dfs(map, i, j + 1);
        }


        if(i > 0) {
            c = dfs(map, i - 1, j);
        }

        if(i < h - 1) {
            d = dfs(map, i + 1, j);
        }

        return a + b + c + d + 1;
    }

    public static void main(String[] args) {
        System.out.print(new LeetCode695().maxAreaOfIsland(new int[][]{{1,1},{1,0}}));
    }
}
