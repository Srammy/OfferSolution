//----------------------方法1：自己的递归------------------------------------
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return verifySubSquence(sequence, 0, sequence.length - 1);
        
    }
    
     private boolean verifySubSquence(int[] sequence, int left, int right) {
        if (left >= right) return true;
        int target = sequence[right];
        int midIndex = -1; // 左右子树的分界
        for (int i = left; i < right; i++) {
            if(sequence[i] > target) {
                midIndex = i;
                break;
            }
        }
        // sequence中没有比target大的部分，也就是没有右子树的情况，此时只需要递归看左子树是否满足要求 
        if (midIndex == -1) return verifySubSquence(sequence, left, right - 1);
		// 第一个数，也就是sequence[left]就比target大，也就是没有左子树的情况，此时需要看一下右子树是否都比target大以及右子树是否满足要求
        else if (midIndex == left) return verifyLarger(sequence, midIndex, right - 1, target) && verifySubSquence(sequence, midIndex, right - 1);
        // 左右子树都存在
		return verifyLarger(sequence, midIndex, right - 1, target) && verifySubSquence(sequence, left, midIndex - 1) && verifySubSquence(sequence, midIndex, right - 1); 
        
    }
    
    private boolean verifyLarger(int[] sequence, int left, int right, int target) {
        for(int i = left; i <= right; i++) {
            if (sequence[i] < target) {
                return false;
            }
        }
        return true;
    }
}
//--------------------------方法2：简化的递归（思路和方法1一样，也是分为左右子树）--------------------
public class Solution {

    public boolean helpVerify(int [] sequence, int start, int root){
        if(start >= root)return true;
        int key = sequence[root];
        int i;
        //找到左右子数的分界点
        for(i=start; i < root; i++)
            if(sequence[i] > key)
                break;
        //在右子树中判断是否含有小于root的值，如果有返回false
        for(int j = i; j < root; j++)
            if(sequence[j] < key)
                return false;
        return helpVerify(sequence, start, i-1) && helpVerify(sequence, i, root-1);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)return false;
        return  helpVerify(sequence, 0, sequence.length-1);

    }
}