class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                int a = st.pop();
                int b = st.pop();
                st.push(a+b);
            }
            else if(s.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b-a);
            }
            else if(s.equals("*")){
                int a = st.pop();
                int b = st.pop();
                st.push(a*b);
            }
            else if(s.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            }
            else{
                int tmp = Integer.parseInt(s);
                st.push(tmp);
            }
        }
        return st.pop();
    }
}