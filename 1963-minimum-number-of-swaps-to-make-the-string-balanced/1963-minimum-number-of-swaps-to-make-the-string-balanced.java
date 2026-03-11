class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c==']'){
                if(!st.isEmpty() && st.peek()=='['){
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }
            else{
                    st.push(c);
                }
        }
        int ans = st.size()/2;
        // System.out.println(ans);
        // System.out.println(ans%2);
        // System.out.println(ans/2);
        
        return ans%2 + ans/2;
    }
}