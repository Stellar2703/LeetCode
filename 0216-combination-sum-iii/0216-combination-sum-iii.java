class Solution {
    private void f(int num,int count,int sum,List<List<Integer>> ans , ArrayList<Integer> temp){
        if(count==0 && sum==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(count<0 || sum<0 || num>9){
            return;
        }

        temp.add(num);
        f(num+1,count-1,sum-num,ans,temp);
        temp.remove(temp.size()-1);
        f(num+1,count,sum,ans,temp);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        f(1,k,n,ans,temp);
        return ans;
    }
}