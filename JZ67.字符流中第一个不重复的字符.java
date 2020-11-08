//==========================剑指offer上的实现==================
import java.util.*;
public class Solution {
    Queue<Character> q = new LinkedList<>();
    Map<Character, Integer> charAppearTimeMap = new HashMap<>();
    
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        q.add(ch);
        if (charAppearTimeMap.containsKey(ch)) {
            int time = charAppearTimeMap.get(ch);
            time = time + 1;
            charAppearTimeMap.put(ch, time);
        } else {
            charAppearTimeMap.put(ch, 1);
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (char c : q) {
            if (charAppearTimeMap.get(c) == 1) {
                return c;
            }
        }
        return '#';
    }
}