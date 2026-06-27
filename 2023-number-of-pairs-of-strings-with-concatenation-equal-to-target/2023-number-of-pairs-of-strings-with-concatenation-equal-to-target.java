class Solution {
    public int numOfPairs(String[] nums, String target) {
        int n = nums.length;
        int count =0;
        for(int i =0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(nums[i]);
                sb.append(nums[j]);
                if(j!=i && target.equals(sb.toString())){
                    count++;
                }
                sb.setLength(0);
            }
        }
        return count;
    }
}