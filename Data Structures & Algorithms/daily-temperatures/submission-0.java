class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack= new Stack();
        for(int i = 0;i<temperatures.length;i++){
            while(!stack.empty() && temperatures[i]>temperatures[stack.peek()]){
                int j = stack.pop();
                res[j] = i-j; 
            }
            stack.push(i);
        }
        while(!stack.empty()){
            res[stack.pop()] = 0;
        }
        return res;
    }
}