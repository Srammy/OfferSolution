public class Solution {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    
    public void push(int x){
        stack1.push(x);
        if(stack2.isEmpty() || stack2.peek()>x)
            stack2.push(x);
        else
            stack2.push(stack2.peek());
    }
    
    public void pop(){
        stack1.pop();
        stack2.pop();
    }
    
    public int top(){
        return stack1.peek();
    }
    
    public int min() {
        return stack2.peek();
    }
}