class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i =0;i<n;i++){
            hm.put(score[i],i);
        }
        String [] ans = new String[n];
        Arrays.sort(score);
        int pos = 1;
        for(int i =n-1;i>=0;i--){
            if(pos == 1){
                ans[hm.get(score[i])] = "Gold Medal";
            }
            else if(pos == 2){
                ans[hm.get(score[i])] = "Silver Medal";
            }
            else if(pos == 3){
                ans[hm.get(score[i])] = "Bronze Medal";
            }
            else{
                ans[hm.get(score[i])] = Integer.toString(pos);
            }
            pos++;
        }
        return ans;
    }
}