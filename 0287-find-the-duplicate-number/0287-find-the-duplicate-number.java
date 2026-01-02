class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0,fast = 0,n=nums.length;
        while (true){
            fast= nums[nums[fast]];
            slow = nums[slow];
            if(slow==fast) break;
        }
        slow = 0;
        while (true){
            slow  = nums[slow];
            fast = nums[fast];
            if(slow==fast){
                break;
            }
        }
        return slow;
    }
}