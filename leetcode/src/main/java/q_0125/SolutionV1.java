package q_0125;

/**
 * 验证回文串
 *
 * @author pengbo.wang
 * @date 2020/07/11 3:32 下午
 */
public class SolutionV1 {

    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(s));
    }


    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }

        String str = sb.toString();
        int left = 0;
        int right = str.length() - 1;
        char[] chars = str.toCharArray();
        while (left < right) {
            if (Character.toLowerCase(chars[left]) == Character.toLowerCase(chars[right])) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }


}
