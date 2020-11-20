//==================leetCode 剑指 Offer 19. 正则表达式匹配=============================
//参考链接：https://www.cnblogs.com/le-le/p/12864549.html
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        char[] str = s.toCharArray();
        char[] ptr = p.toCharArray();
        
        if (str.length == 0 && ptr.length == 0) {
            return true;
        }

        if (str.length != 0 && ptr.length == 0) {
            return false;
        }

        return matchCore(str, 0, ptr, 0);
    }

    private boolean matchCore(char[] str, int s, char[] ptr, int p) {
        
        // str匹配到尾部，ptr匹配到尾部，匹配成功
        if (s == str.length && p == ptr.length) {
            return true;
        }

        // str没有匹配到尾部，ptr匹配到尾部，匹配失败
        if(s != str.length && p == ptr.length){
            return false;
        }

        // ptr的下一个字符为‘*’，并且没有越界
        if (p + 1 < ptr.length && ptr[p + 1] == '*') {
            //如果s没有匹配到尾部，str[s] == ptr[p] 或者ptr[p] == '.'
            if ((s != str.length && str[s] == ptr[p]) || (s != str.length && ptr[p] == '.')) {
                return matchCore(str, s, ptr, p + 2) ||	//X*匹配0个字符
                       matchCore(str, s + 1, ptr, p + 2)||	//X*匹配1个字符
                       matchCore(str, s + 1, ptr, p);		//X*匹配多个字符，继续匹配s1下个字符
            } else {
                //str[s] != ptr[p] 并且 ptr[p] ！= ‘.’，匹配不成功，跳过‘ * ’
                return matchCore(str, s, ptr, p + 2);
            }
        }

        //str没有匹配到尾部，p == s 或者 p = '.'，但ptr下一位不是‘*’
        if((s != str.length && str[s] == ptr[p]) || (s != str.length && ptr[p] == '.')){
            // 匹配s下一位与p下一位
            return matchCore(str,s + 1,ptr,p + 1);
        }

        return false;
    }
}

//================================剑指offer=======================================
public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null) {
            return false;
        }
        
        if (str.length == 0 && pattern.length == 0) {
            return true;
        }
        
        if (str.length != 0 && pattern.length == 0) {
            return false;
        }
        
        return matchCore(str, 0, pattern, 0);
    }
    
    private boolean matchCore(char[] str, int s, char[] ptr, int p) {
        
        // str匹配到尾部，ptr匹配到尾部，匹配成功
        if (s == str.length && p == ptr.length) {
            return true;
        }

        // str没有匹配到尾部，ptr匹配到尾部，匹配失败
        if(s != str.length && p == ptr.length){
            return false;
        }

        // ptr的下一个字符为‘*’，并且没有越界
        if (p + 1 < ptr.length && ptr[p + 1] == '*') {
            //如果s没有匹配到尾部，str[s] == ptr[p] 或者ptr[p] == '.'
            if ((s != str.length && str[s] == ptr[p]) || (s != str.length && ptr[p] == '.')) {
                return matchCore(str, s, ptr, p + 2) ||	//X*匹配0个字符
                       matchCore(str, s + 1, ptr, p + 2)||	//X*匹配1个字符
                       matchCore(str, s + 1, ptr, p);		//X*匹配多个字符，继续匹配s1下个字符
            } else {
                //str[s] != ptr[p] 并且 ptr[p] ！= ‘.’，匹配不成功，跳过‘ * ’
                return matchCore(str, s, ptr, p + 2);
            }
        }

        //str没有匹配到尾部，p == s 或者 p = '.'，但ptr下一位不是‘*’
        if((s != str.length && str[s] == ptr[p]) || (s != str.length && ptr[p] == '.')){
            // 匹配s下一位与p下一位
            return matchCore(str,s + 1,ptr,p + 1);
        }

        return false;
    }
}