package Offer58;

import java.util.Arrays;

//注：该题可直接用subString方法解决，下面的写法只有在c语言下才可实现，只是我用了java的语法，实际运行达不到目标效果
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse("abcdef", 0, 4));
        System.out.println(solution.reverseLeftWords("abcdef", 2));
    }

    public String reverseLeftWords(String s, int n) {
        reverse(s, 0, n - 1);
        reverse(s, n, s.length() - 1);
        return reverse(s, 0, s.length() - 1);
    }

    public String reverse(String s, int left, int right) {
        char[] chars = s.toCharArray();
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return Arrays.toString(chars);
    }
}
