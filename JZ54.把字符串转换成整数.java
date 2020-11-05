//==============LeetCode上的实现   剑指 Offer 67. 把字符串转换成整数 ========================
class Solution {
    public int strToInt(String str) {
        if (str == null) {
            return 0;
        }            

        char[] charArray = str.trim().toCharArray();
        if (charArray.length == 0) { // str可能由空格' '组成
            return 0;
        }

        int i = 1;
        int sign = 1; // 符号位
        int res = 0; // 返回结果
        int boundary = Integer.MAX_VALUE/10; // 边界值
        
        if(charArray[0] == '-') sign = -1;
        else if(charArray[0] != '+') i = 0;
        for(int j = i; j < charArray.length; j++) {
            if(charArray[j] < '0' || charArray[j] > '9') break;
            if(res > boundary || res == boundary && charArray[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (charArray[j] - '0');
        }
        return sign * res;
    }
}
//===============剑指offer上的实现=============================
public class Solution {
    public int StrToInt(String str) {
        if (str == null) {
            return 0;
        }            

        char[] charArray = str.trim().toCharArray();
        if (charArray.length == 0) { // str可能由空格' '组成
            return 0;
        }

        int i = 1;
        int sign = 1; // 符号位
        int res = 0; // 返回结果
        int boundary = Integer.MAX_VALUE/10; // 边界值
        
        if(charArray[0] == '-') sign = -1;
        else if(charArray[0] != '+') i = 0;
        for(int j = i; j < charArray.length; j++) {
            if(charArray[j] < '0' || charArray[j] > '9') return 0;
            if(res > boundary || res == boundary && charArray[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (charArray[j] - '0');
        }
        return sign * res;
    }
}