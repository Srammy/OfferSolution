import java.util.ArrayList;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
      if(pushA.length == 0 || popA.length == 0) {
    		return false;
    	}
    	
    	ArrayList<Integer> stack = new ArrayList<Integer>();
    	
    	int index = 0;
    	
    	for (int i = 0; i < pushA.length; i++) {
			stack.add(pushA[i]);
			
			while(!stack.isEmpty() && (stack.get(stack.size() - 1) == popA[index])) {
				stack.remove(stack.size() - 1);
				index++;
			}
		}
    	
    	return stack.isEmpty();
    }
}