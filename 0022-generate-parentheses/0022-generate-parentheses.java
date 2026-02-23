class Solution {
    private void f(List<String> ans, StringBuilder temp, int left,int right){
        if(right == 0 && left==0){
            ans.add(temp.toString());
            return;
        }
        if(left>0){
            temp.append("(");
            f(ans,temp,left-1,right);
            temp.setLength(temp.length()-1);
        }
        if(left<right){
            temp.append(")");
            f(ans,temp,left,right-1);
            temp.setLength(temp.length()-1);
        }

    }
    public List<String> generateParenthesis(int n) {
        StringBuilder temp = new StringBuilder();
        List<String> ans = new ArrayList<>();
        f(ans,temp,n,n);
        return ans;
    }
}