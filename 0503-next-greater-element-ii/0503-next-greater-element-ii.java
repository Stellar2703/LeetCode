class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int [] nge = new int[n];
        for (int i=2*n-1 ; i>=0 ; i--){
            int curr_ele = nums[i%n];
            while(!st.isEmpty() && st.peek()<= curr_ele){
                st.pop();
            }
            if (i<=n-1){
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(curr_ele);
        }
        return nge;
    }
}