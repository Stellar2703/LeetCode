class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temp.length];
        for(int i=temp.length-1;i>=0;i--){
            while(!st.isEmpty()){
                if(temp[st.peek()]<temp[i]){
                    st.pop();
                }
                else{
                    ans[i] = st.peek() - i;
                    break;
                }
            }
            st.push(i);
        }
        return ans;
    }
}