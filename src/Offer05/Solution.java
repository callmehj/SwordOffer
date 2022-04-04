package Offer05;

public class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            sb.append((c == ' ' ? "%20" : c));
        }
        return sb.toString();
    }
}
