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
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if(pRoot == null) {
            return new ArrayList<ArrayList<Integer>>();
        }

        int level = -1; // 当前所在树的层数
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> q = new ArrayList<>();
        q.add(pRoot);

        while(!q.isEmpty()) {
            int everyLevelSize = q.size(); // 每一层节点的个数
            ArrayList<Integer> everyLevelList = new ArrayList<>();
            level++;

            for(int i = 0; i < everyLevelSize; i++) {
                TreeNode cur = q.get(0);
                q.remove(0);
                if(level % 2 == 0) {
                    everyLevelList.add(cur.val);
                } else {
                    everyLevelList.add(0, cur.val);
                }

                if (cur.left != null) {
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