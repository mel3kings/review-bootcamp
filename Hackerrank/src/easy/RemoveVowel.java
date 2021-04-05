package easy;

//https://leetcode.com/problems/remove-vowels-from-a-string/

public class RemoveVowel {
    public String removeVowels(String s) {
        StringBuffer sb = new StringBuffer();
        char[] val = s.toCharArray();
        for (char c : val) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                continue;
            }
            sb.append(String.valueOf(c));
        }
        return sb.toString();
    }
}
