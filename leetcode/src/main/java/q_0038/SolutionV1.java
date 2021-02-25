package q_0038;

/**
 * 外观数列
 *
 * @author pengbo
 * @since 2021/2/23
 */
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        // n=1 1
        // n=2 11
        // n=3 21
        // n=4 1211
        // n=5 111221
        // n=6 312211
        // n=7 13112221
        System.out.println(solution.countAndSay(7));
    }

    // 1<=n<=30
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append('1');

        for (int i = 2; n > 1 && i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            char cache = '0';
            int cacheSize = 0;

            for (int j = 0; j < sb.length(); j++) {
                if (cache != '0' &&  cache != sb.charAt(j)) {
                    temp.append(cacheSize);
                    temp.append(cache);
                    cacheSize = 0;
                }
                cache = sb.charAt(j);
                cacheSize++;
            }


            if (cacheSize > 0) {
                temp.append(cacheSize);
                temp.append(cache);
            }
            sb = temp;
        }

        return sb.toString();
    }
}
