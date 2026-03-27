class Solution {
    public List<String> summaryRanges(int[] nums) {
        int l = 0;
        if(nums.length == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for(int r = 1;r<nums.length;r++){
            if(nums[r-1]+1 != nums[r]){
               if(r-l==1) {
                String temp = Integer.toString(nums[l]);
                ans.add(temp);
                l=r;
               }
               else{
                StringBuilder temp = new StringBuilder();
                temp.append(nums[l]);
                temp.append("->");
                temp.append(nums[r-1]);
                l=r;
                ans.add(temp.toString());
               }
            }
        }
        if(l==nums.length-1){
            ans.add(Integer.toString(nums[nums.length-1]));
        }
        else{
            StringBuilder temp = new StringBuilder();
                temp.append(nums[l]);
                temp.append("->");
                temp.append(nums[nums.length-1]);
                ans.add(temp.toString());
        }
        return ans;
    }
}