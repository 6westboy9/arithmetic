package q_0017;

import java.util.*;

/**
 * 电话号码的字母组合
 *
 * @author pengbo
 * @since 2021/2/20
 */
public class SolutionV1 {

    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        // System.out.println(solution.letterCombinations("2315"));
        System.out.println(solution.letterCombinations("23"));
    }

    static final Map<Character, List<Character>> validDigits;

    static {
        validDigits = new HashMap<>();
        validDigits.put('2', newArrayList('a', 'b', 'c'));
        validDigits.put('3', newArrayList('d', 'e', 'f'));
        validDigits.put('4', newArrayList('g', 'h', 'i'));
        validDigits.put('5', newArrayList('j', 'k', 'l'));
        validDigits.put('6', newArrayList('m', 'n', 'o'));
        validDigits.put('7', newArrayList('p', 'q', 'r', 's'));
        validDigits.put('8', newArrayList('t', 'u', 'v'));
        validDigits.put('9', newArrayList('w', 'x', 'y', 'z'));
    }

    private static List<Character> newArrayList(char... chars) {
        List<Character> characters = new ArrayList<>();
        for (char ch : chars) {
            characters.add(ch);
        }
        return characters;
    }


    public List<String> letterCombinations(String digits) {
        char[] charArray = digits.toCharArray();

        char[] afterFilterCharArray = new char[charArray.length];
        int idx = 0;
        for (char ch : charArray) {
            if (validDigits.containsKey(ch)) {
                afterFilterCharArray[idx++] = ch;
            }
        }

        List<String> resultStrList = new ArrayList<>();
        if (afterFilterCharArray.length > 0) {
            for (int i = 0; i < idx; i++) {
                List<Character> characters = validDigits.get(afterFilterCharArray[i]);
                List<String> temp = new ArrayList<>(resultStrList.isEmpty() ? characters.size() : resultStrList.size() * characters.size());
                if (resultStrList.isEmpty()) {
                    for (Character character : characters) {
                        temp.add(String.valueOf(character));
                    }
                } else {
                    for (String tmpStr : resultStrList) {
                        for (Character character : characters) {
                            temp.add(tmpStr + character);
                        }
                    }
                }
                resultStrList = temp;
                // System.out.println(resultStrList);
            }
        }
        return resultStrList;
    }
}
