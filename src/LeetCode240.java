/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.22 19:47
 */
public class LeetCode240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int h = matrix.length;
        if(h == 0) {
            return false;
        }
        int w = matrix[0].length;

        int i = 0, j = w - 1;
        while (i < h && j >= 0) {
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

}
