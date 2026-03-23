class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i =0;i<n;i++){
            int temp = 0;
            int count = 0;
            int num = nums[i];
            for(int j = 1;j*j<=num;j++){
                int q = num/j;
                if(num%j==0){
                    if(q!=j){
                        count +=2;
                        temp+=j+q;
                    }
                    else{
                    count ++;
                    temp+=j;
                    }
                }
                if(count>4) break;
            }
                if(count ==4){
                    ans+=temp;
                }
        }
        return ans;
    }
}