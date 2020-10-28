//===============LeetCode  剑指 Offer 58 - II. 左旋转字符串=======================
class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();
    }
}
//===============剑指offer=========================================
public class Solution {
    public String LeftRotateString(String str,int n) {
        if (n > str.length() || str == null) return "";
        StringBuilder res = new StringBuilder();
        for(int i = n; i < str.length(); i++)
            res.append(str.charAt(i));
        for(int i = 0; i < n; i++)
            res.append(str.charAt(i));
        return res.toString();
    }
}