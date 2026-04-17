class Solution {
    private int reverse(int n){
        int temp = 0;
        while(n > 0){
            temp = temp * 10 + (n % 10);
            n /= 10;
        }
        return temp;
    }


    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int num = reverse(nums[i]);
            if(mp.containsKey(nums[i])){
                ans = Math.min(ans,i - mp.get(nums[i]));
            }   

            mp.put(num,i);
        }

        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}