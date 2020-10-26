//==============LeetCode 剑指 Offer 50. 第一个只出现一次的字符=========
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> res = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            res.put(c, !res.containsKey(c));
        for(Map.Entry<Character, Boolean> d : res.entrySet()){
           if(d.getValue()) return d.getKey();
        }
        return ' ';
    }
}
//===========剑指offer======================
import java.util.*;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = str.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(int i = 0; i < sc.length; i++) {
            if(dic.get(sc[i])) return i;
        }
            
        return -1;
    }
}