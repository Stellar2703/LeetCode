class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        StringBuilder sb =new StringBuilder();
        String[] arr = path.split("/");
        for(String s : arr){
            if(s.equals(".") || s.equals("")) continue;
            else if(s.equals("..")) {
                if(!st.isEmpty())st.pop();
            }
            else st.push(s);
        }
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
            sb.insert(0,"/");
        }
        return sb.length() == 0 ?"/" : sb.toString();
    }
}