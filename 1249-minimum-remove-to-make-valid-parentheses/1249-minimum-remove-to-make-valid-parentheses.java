    class Solution {
        public String minRemoveToMakeValid(String s) {
            StringBuilder sb = new StringBuilder(s);
            Stack<Integer> st =  new Stack<>();
            for(int i =0;i<sb.length();i++){
                if(sb.charAt(i) =='(') st.push(i);
                else if(sb.charAt(i) == ')'){
                    if(!st.isEmpty() && sb.charAt(st.peek())=='(') st.pop();
                    else{
                    st.push(i);
                }
                }
            }
            while(!st.isEmpty()){
                int index = st.pop();
                sb.setCharAt(index, '#');
            }
            StringBuilder ans = new StringBuilder();
            for(int i=0;i<sb.length();i++){
                if(sb.charAt(i)!='#'){
                    ans.append(sb.charAt(i));
                }
            }
            return ans.toString();
        }
    }