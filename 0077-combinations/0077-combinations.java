class Solution {
    public void f(int n , int k ,int start,List<List<Integer>> ans,List<Integer> temp ){
        if(k==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start;i<=n-k+1;i++){
            temp.add(i);
            f(n,k-1,i+1,ans,temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        f(n,k,1,ans,temp);
        return ans; 
    }
}