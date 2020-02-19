import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.18 14:29
 */
public class LeetCode207 implements Important {

    public boolean canFinish(int numCourses, int[][] arr) {
        boolean[][] map = new boolean[numCourses][numCourses];
        int[] count = new int[numCourses];

        for (int i = 0; i < arr.length; i++) {
            map[arr[i][1]][arr[i][0]] = true;
            count[arr[i][0]]++;
        }

        int cnt = 0;
        Queue<Integer> queue = new ArrayDeque<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            if(count[i] == 0) {
                queue.offer(i);
                cnt++;
            }
        }

        while (!queue.isEmpty()) {
            int id = queue.poll();
            for (int i = 0; i < numCourses; i++) {
               if(map[id][i]) {
                   count[i]--;
                   if(count[i] == 0) {
                       queue.offer(i);
                       cnt++;
                   }
               }
            }
        }

        return cnt == queue.size();
    }

}
