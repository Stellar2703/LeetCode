class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] arr= new int[nums.length];
        
        for(int i=1;i<nums.length;i++){
           arr[i]  = nums[i-1]+arr[i-1];
        }
        int temp =0;
        for(int i=nums.length-1;i>=0;i--){
           arr[i] = Math.abs(arr[i]-temp);
           temp+=nums[i];
        }
        return arr;
    }
}