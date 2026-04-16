class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer,List<Integer>> mp = new HashMap<>();
        int n = nums.length;
        for(int i =0;i<n;i++){
            mp.putIfAbsent(nums[i],new ArrayList<>());
            mp.get(nums[i]).add(i);
        }

        List<Integer> ans =  new ArrayList<>();

        if(mp.size()==n) {
            for(int i=0;i<queries.length;i++){
                ans.add(-1);
            }
            return ans;
        }

        // for(int q : queries){
        //     int res = Integer.MAX_VALUE;
        //     for(int pos : mp.get(nums[q])){
        //         if(pos!=q){
        //             int ini = Math.abs(pos-q);
        //             int cir = Math.min(ini,n-ini);
        //             res = Math.min(res,Math.min(ini,cir));
        //         }
        //     }
        //     ans.add(res == Integer.MAX_VALUE ? -1 : res);
        // }
        //  Brute force without ninary search

        for(int q: queries){

            if(mp.get(nums[q]).size() == 1){
                ans.add(-1);
                continue;
            }

            int ind = Collections.binarySearch(mp.get(nums[q]),q);
            int size = mp.get(nums[q]).size();

            int left = mp.get(nums[q]).get((ind-1+size)%size);
            int diff1 = Math.abs(left - q);
            int left_ans = Math.min(diff1, n - diff1);

            int right = mp.get(nums[q]).get((ind+1)%size);
            int diff2 = Math.abs(right - q);
            int right_ans = Math.min(diff2, n - diff2);

            int res = Math.min(right_ans,left_ans);
            ans.add(res);
        }

        return ans;
    }
}