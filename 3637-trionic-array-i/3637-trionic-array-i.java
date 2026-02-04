class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 1;
        while (i < n) {
            if (nums[i - 1] < nums[i]) {
                while (i < n && nums[i - 1] < nums[i])
                    i++;
                if (i < n && nums[i - 1] > nums[i]) {
                    while (i < n && nums[i - 1] > nums[i])
                        i++;

                    if (i < n && nums[i - 1] < nums[i]) {
                        while (i < n && nums[i - 1] < nums[i])
                            i++;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } 
            else {
                return false;
            }
        }
        return true;
    }
}