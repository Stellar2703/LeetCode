class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = 100000;
        for(int i =l;i<=r;i++){
            int sum = 0;
            int left = 0;
            for(int right = 0;right<nums.size();right++){
                if(right-left+1<i)sum+=nums.get(right);
                else{
                    sum+=nums.get(right);
                    if(sum>0) min = Math.min(sum,min);
                    sum-=nums.get(left);
                    left++;
                }

            }
        }
        return min==100000 ? -1 : min;
    }
}