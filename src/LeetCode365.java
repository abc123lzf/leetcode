/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.18 13:40
 */
public class LeetCode365 implements Important {

    public boolean canMeasureWater(int x, int y, int z) {
        if(x == 0 && y == 0) {
            return z == 0;
        }

        if(y == 0) {
            return z % x == 0;
        } else if(x == 0) {
            return z % y == 0;
        }

        int gcd = findGCD(Math.max(x, y), Math.min(x, y));
        System.out.println(gcd);
        return y % gcd == 0;
    }

    private int findGCD(int x, int y) {
        return y == 0 ? x : findGCD(y, x % y);
    }


    public static void main(String[] args) {
        System.out.print(12 % 1);
    }


}
