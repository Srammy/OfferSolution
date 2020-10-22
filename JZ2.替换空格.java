public class Solution {
    public String replaceSpace(StringBuffer str) {
    	int length = str.length();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != ' ') {
                res.append(str.charAt(i));
            } else {
                res.append("%20");
            }
        }
        return res.toString();

    }
}