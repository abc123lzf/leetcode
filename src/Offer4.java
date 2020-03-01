/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.28 17:07
 */
public class Offer4 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int h = matrix.length;
        int w = matrix[0].length;

        int i = 0, j = w - 1;
        while (i < h && j >= 0) {
            int num = matrix[i][j];
            if(num == target) {
                return true;
            } else if(target < num) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(findNumberIn2DArray(arr, 5));
    }

}
