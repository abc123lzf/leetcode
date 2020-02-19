/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.18 14:53
 */
public class LeetCode547 {

    public int findCircleNum(int[][] map) {
        int cnt = 0;
        int h = map.length;
        int w = map[0].length;

        boolean[] vis = new boolean[h];
        for (int i = 0; i < h; i++) {
            if(!vis[i]) {
                dfs(i, map, vis, h, w);
                cnt++;
            }
        }

        return cnt;
    }

    private void dfs(int user, int[][] map, boolean[] vis, int h, int w) {
        if(vis[user]) {
            return;
        }

        vis[user] = true;
        for (int i = 0; i < w; i++) {
            if(map[user][i] == 1 && !vis[i]) {
                dfs(i, map, vis, h, w);
            }
        }
    }
}
