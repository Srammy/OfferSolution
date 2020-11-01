//============LeetCode 剑指 Offer 58 - I. 翻转单词顺序================
//----------方法1---------------------
class Solution {
    public String reverseWords(String s) {
        String s1 = s.trim();
        String[] s2 = s1.split(" ");
       
        StringBuffer sb = new StringBuffer();
        for (int i = (s2.length - 1); i >= 0; i--) {
            System.out.println(i + s2[i]);
            if ("".equals(s2[i])) {
                continue;
            }
            if (i != 0) {
                sb.append(s2[i]);
                sb.append(" ");
            } else {
                sb.append(s2[i]);
            }
            
        }
        return sb.toString();
    }
}
//-------------方法2--------------------
class Solution {
    public String reverseWords(String s) {
        String s1 = s.trim();
        int i = s1.length() - 1;
        int j = i;
        StringBuffer sb = new StringBuffer();
        while (i >= 0) {
            while (i >= 0 && s1.charAt(i) != ' ' ) {
                i--;
            }
            sb.append(s1.substring(i+1, j+1) + " ");
            while (i >= 0 && s1.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }
}
//============剑指offer========================
public class Solution {
    public String ReverseSentence(String str) {
        if(str.length() == 0 || str.trim().equals("")){//需要将多个空格的情况考虑进来
            return str;
        }
        String s1 = str.trim();
        String[] s2 = s1.split(" ");
       
        StringBuffer sb = new StringBuffer();
        for (int i = (s2.length - 1); i >= 0; i--) {
            System.out.println(i + s2[i]);
            if ("".equals(s2[i])) {
                continue;
            }
            if (i != 0) {
                sb.append(s2[i]);
                sb.append(" ");
            } else {
                sb.append(s2[i]);
            }
            
        }
        return sb.toString();
    }
}