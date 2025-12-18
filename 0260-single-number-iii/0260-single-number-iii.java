class Solution {
    public int[] singleNumber(int[] nums) {
        int pos = 0;
        int number;
        int a=0 , b=0;
        for (int i=0;i<nums.length;i++){
            pos = pos ^ nums[i];
        }
        number = pos & (-pos);
        for (int i=0;i<nums.length;i++){
            if ((number & nums[i])!=0){
                b=b^nums[i];
            }else{
                a=a^nums[i];
            }
        }
        return new int[]{a,b};
    }
}
