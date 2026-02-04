class Solution {
    public boolean isTrionic(int[] nums) {
        int inc = 0;
        int dec = 0;
        int index = 1;
        while (index < nums.length) {
            if (nums[index - 1] < nums[index]) {
                while (index < nums.length && nums[index - 1] < nums[index])
                    index++;
                if (index < nums.length && nums[index - 1] > nums[index]) {
                    while (index < nums.length && nums[index - 1] > nums[index])
                        index++;

                    if (index < nums.length && nums[index - 1] < nums[index]) {
                        while (index < nums.length && nums[index - 1] < nums[index])
                            index++;
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