class Solution {
    public boolean search(int[] nums, int target) {
         int st = 0,end =nums.length-1;

        while(st<=end){
            int mid = (st+end)/2;
            if(nums[mid]==target)return true;
            if(nums[mid]==nums[st] && nums[mid]==nums[end]){
                st+=1;
                end-=1;
                continue;
            }
            if(nums[st]<=nums[mid]){
                if(target<= nums[mid] && target>=nums[st]){
                    end = mid-1;
                }
                else{
                    st = mid+1;
                }
            }
            else{
                if(target>=nums[mid] && target<=nums[end]){
                    st = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
            return false;
    }
}