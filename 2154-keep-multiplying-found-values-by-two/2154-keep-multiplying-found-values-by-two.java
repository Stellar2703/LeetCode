class Solution {
    public int findFinalValue(int[] nums, int original) {
        
        boolean found = true;
        while(found){
            found  = false;
            for(int num : nums){
                if(num==original){
                    original*=2;
                    found = true;
                }
            }
            if(!found){
                return original;
            }
        }
        return 0;
    }
}