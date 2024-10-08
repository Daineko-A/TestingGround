//Given an integer x, return true if x is a palindrome, and false otherwise.
//
//
// Example 1:
//
//
//Input: x = 121
//Output: true
//Explanation: 121 reads as 121 from left to right and from right to left.
//
//
// Example 2:
//
//
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it
//becomes 121-. Therefore it is not a palindrome.
//
//
// Example 3:
//
//
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//
//
//
// Constraints:
//
//
// -2³¹ <= x <= 2³¹ - 1
//
//
//
//Follow up: Could you solve it without converting the integer to a string?
//
// Related Topics Math 👍 10863 👎 2577


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public boolean isPalindrome(int x) {
//        String s = String.valueOf(x);
//        List<Character> collect = s.chars()
//                .mapToObj(a -> (char) a)
//                .collect(Collectors.toList());
//        Collections.reverse(collect);
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length - 1; i++) {
//            if (chars[i] != collect.get(i)){
//                return false;
//            }
//        }
//        return true;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
