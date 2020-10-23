//==================LeetCode上的实现   剑指 Offer 38. 字符串的排列===========================
//-------------方法1------------------------
/*
用了一个布尔数组来标记是否访问，解决访问重复字母时存在的退出循环问题
*/
class Solution {
    public String[] permutation(String s) {
        List<String> paths = new ArrayList<>();
        char[] c = s.toCharArray();
        boolean[] visited = new boolean[c.length];
        backtrack(new StringBuffer(), c, paths, visited);
        
        Set<String> resSet = new HashSet<>(paths);

        Object[] res = resSet.toArray();
        String[] resArray = new String[res.length];
        for (int i = 0; i < res.length; i++) {
            resArray[i] = (String)res[i];
        }
        return resArray;
    }

    private void backtrack(StringBuffer path, char[] c, List<String> paths, boolean[] visited) {
        if (path.length() == c.length) {
            paths.add(path.toString());
            return;
        }

        for (int i = 0; i < c.length; i++) {
            if (!isValid(i, visited)) {
                continue;
            }

            path.append(c[i]);
            visited[i] = true;
            backtrack(path, c, paths, visited);
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;

        }

    }

    private boolean isValid(int i, boolean[] visited) {
        if (visited[i] == true) {
            return false;
        }

        return true;
    }
}
//--------------方法2----------------------
// 和方法1思路相同，只是稍微简化了一下代码
class Solution {
    public String[] permutation(String s) {
        Set<String> paths = new HashSet<>();
        char[] c = s.toCharArray();
        boolean[] visited = new boolean[c.length];

        backtrack(new StringBuffer(), c, paths, visited);
        

        Object[] res = paths.toArray();
        String[] resArray = new String[res.length];
        for (int i = 0; i < res.length; i++) {
            resArray[i] = (String)res[i];
        }
        return resArray;
    }

    private void backtrack(StringBuffer path, char[] c, Set<String> paths, boolean[] visited) {
        if (path.length() == c.length) {
            paths.add(path.toString());
            return;
        }

        for (int i = 0; i < c.length; i++) {
            if (!isValid(i, visited)) {
                continue;
            }

            path.append(c[i]);
            visited[i] = true;
            backtrack(path, c, paths, visited);
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;
            

        }

    }

    private boolean isValid(int i, boolean[] visited) {
        if (visited[i] == true) {
            return false;
        }

        return true;
    }
}

//========================剑指offer上实现============================
import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        Set<String> paths = new HashSet<>();
        char[] c = str.toCharArray();
        boolean[] visited = new boolean[c.length];

        backtrack(new StringBuffer(), c, paths, visited);
        
        ArrayList<String> res = new ArrayList<>(paths);
        return res;
    }
    
    private void backtrack(StringBuffer path, char[] c, Set<String> paths, boolean[] visited) {
        if (path.length() == c.length) {
            paths.add(path.toString());
            return;
        }

        for (int i = 0; i < c.length; i++) {
            if (!isValid(i, visited)) {
                continue;
            }

            path.append(c[i]);
            visited[i] = true;
            backtrack(path, c, paths, visited);
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;

        }

    }

    private boolean isValid(int i, boolean[] visited) {
        if (visited[i] == true) {
            return false;
        }

        return true;
    }
}
