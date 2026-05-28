class Solution {
    private boolean f(int index,int[] stones, int prev, HashMap<Integer,Integer> mp, Boolean[][] dp){
        if(stones.length-1==index) return true;
        if(index>=stones.length) return false;
        if(dp[index][prev]!=null) return dp[index][prev];
        int curr = stones[index];

        // k-1 jump
        if(mp.containsKey(curr+prev-1)&& prev-1>0){
            if(f(mp.get(curr+prev-1),stones,prev-1,mp,dp)) return dp[index][prev]=true;
        }
        // k jump
        if(mp.containsKey(curr+prev) && prev>0){
            if(f(mp.get(curr+prev),stones,prev,mp,dp)) return dp[index][prev] =true;
        }
        // k+1 jump
        if(mp.containsKey(curr+prev+1)&& prev+1>0){
            if(f(mp.get(curr+prev+1),stones,prev+1,mp,dp)) return dp[index][prev]= true;

        }

        return dp[index][prev] =  false;
    }

    public boolean canCross(int[] stones) {
        Boolean[][] dp = new Boolean[stones.length][stones.length];
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for (int i = 0; i < stones.length; i++) {
            mp.put(stones[i], i);
        }
        if(!mp.containsKey(stones[0]+1)) return false;
        return f(1, stones, 1, mp, dp);
    }
}