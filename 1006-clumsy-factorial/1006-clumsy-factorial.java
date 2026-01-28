class Solution {
    public int clumsy(int n) {
        int i = n-1;
        Stack<Integer> st  = new Stack<>();
        st.push(n);
        while(i>0){
            if(i>0){
                int temp = st.pop();
                int num = temp*i;
                i--;
                st.push(num);
            }
            if(i>0){
                int temp = st.pop();
                int num = temp/i;
                i--;
                st.push(num);
            }
            if(i>0){
                st.push(i);
                i--;
            }
            if(i>0){
                st.push(-i);
                i--;
            }
        }
        int ans=0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}

