            class Solution {
                public int[] resultsArray(int[] nums, int k) {
                    int r = k-1,l=0;
                    boolean is_valid = true;
                    int [] ans = new int[nums.length-k+1];
                    while(r<nums.length){
                        for(int i = l+1;i<=r;i++){
                            if(nums[i-1]+1 != nums[i]){
                                is_valid = false;
                                break;
                            }
                        }
                        if(is_valid) ans[l++] = nums[r];
                        else ans[l++] = -1;
                        is_valid = true; 
                        r++;
                    }
                    return ans;
                }
            }