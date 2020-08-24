import java.util.ArrayList;
import java.util.*;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
//----------------------方法1：先找出所有的路径，然后再留下符合条件（元素和为target）的路径。这里给出了两种DFS，选哪个都可以---------------------------------
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        dfs(root, new ArrayList<Integer>(), paths);
        
        
        Iterator<ArrayList<Integer>> iterator=paths.iterator();
        while (iterator.hasNext()){
            int sum = sum(iterator.next());
            if (sum != target){
                //不是list的remove
                iterator.remove();
            }
      
        }
        
        return paths;
    }
    
    /*
    private void dfs(TreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
        path.add(root.val);
        if (root.left == null && root.right == null) { // 当前节点是叶子节点
			// 嵌套列表：这个clone操作是为了防止后面 path.remove删掉元素后，影响到嵌套列表paths中的元素。
			// 不clone，path删掉元素，paths中对应的也会删掉元素。--->java的引用
            paths.add((ArrayList<Integer>)path.clone()); // 找到一条路径
            
        } 
        
        // 当前节点不是叶子节点，则继续递归。这个和下面的dfs方法相比，是在递归的外面判断是否为空，为空则不递归。下面的方法是进入递归后判断是否为空，为空则不递归
        if (root.left != null) dfs(root.left, path, paths);
        if (root.right != null) dfs(root.right, path, paths); 
    
	    // 这个是为了回溯。当前点是个叶子节点，说明已经找到一条路径了，需要把当前点删掉，返回上一层继续找路径。（深度优先遍历）
        path.remove(path.size()-1);
    }
    */
	
    private void dfs(TreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) { // 当前节点是叶子节点
            paths.add((ArrayList<Integer>)path.clone()); // 找到一条路径
            
        } else { // 当前节点不是叶子节点，则继续递归
            dfs(root.left, path, paths);
            dfs(root.right, path, paths); 
        }
        
        path.remove(path.size()-1);
    }
    
    private int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i: list) {
            sum += i;
        }
        return sum;
    }
}
//----------------------方法2：------------------------
import java.util.ArrayList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        dfs(root, new ArrayList<Integer>(), paths, target);
        return paths;
    }
    
    private void dfs(TreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths, int value) {
        path.add(root.val);
        if (value == root.val && root.left == null && root.right == null) { // 当前节点是叶子节点
			// 嵌套列表：这个clone操作是为了防止后面 path.remove删掉元素后，影响到嵌套列表paths中的元素。
			// 不clone，path删掉元素，paths中对应的也会删掉元素。--->java的引用
            paths.add((ArrayList<Integer>)path.clone()); // 找到一条路径
        } 
        
        if (root.left != null) dfs(root.left, path, paths, value - root.val);
        if (root.right != null) dfs(root.right, path, paths, value - root.val); 
    
	    // 这个是为了回溯。当前点是个叶子节点，说明已经找到一条路径了，需要把当前点删掉，返回上一层继续找路径。（深度优先遍历）
        path.remove(path.size()-1);           
    }
    
}