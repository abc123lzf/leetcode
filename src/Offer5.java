/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.28 17:17
 */
public class Offer5 {

    public String replaceSpace(String str) {
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                len += 3;
            } else {
                len++;
            }
        }

        char[] s = new char[len];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                s[index++] = '%';
                s[index++] = '2';
                s[index++] = '0';
            } else {
                s[index++] = str.charAt(i);
            }
        }

        return new String(s);
    }

}
