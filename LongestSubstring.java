import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public void lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int lengthOfSubstring = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                i++;
                // "aa", when for the second 'a', i=2, Math.max(0, 2-1) => lengthOfSubstring = 1
                lengthOfSubstring = Math.max(lengthOfSubstring, i - j);
            } else {
                set.remove(s.charAt(j));
                j++;
            }
        }

        System.out.println(set.toString() + ": " + lengthOfSubstring);
    }

    public static void main(String[] args) {
        new LongestSubstring().lengthOfLongestSubstring("abcdeabcd");
    }
}
