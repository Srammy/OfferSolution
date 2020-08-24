import java.util.ArrayList;


/*
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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot == null) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> q = new ArrayList<>();
        int everyLevelSize = 0;
        q.add(pRoot);
        
        while(!q.isEmpty()) {
            everyLevelSize = q.size();
            ArrayList<Integer> everyLevelList = new ArrayList<>();
            for(int i = 0; i < everyLevelSize; i++) {
                TreeNode cur = q.get(0);
                q.remove(0);
                
                everyLevelList.add(cur.val);
                
                if(cur.left != null) {
					q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
                
            }
            res.add(everyLevelList);
        }
        return res;
    }
    
}