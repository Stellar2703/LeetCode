class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> ans = new ArrayList<>();
        int n = security.length;
        int[] decCount = new int[n];
        int[] incCount = new int[n];

        for(int i =1;i<n;i++){
            if(security[i]<=security[i-1]){
                decCount[i]=decCount[i-1]+1;
            }
            else{
                decCount[i] = 0;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(security[i]<=security[i+1]){
                incCount[i] = incCount[i+1]+1;
            }
            else{
                incCount[i] = 0;
            }
        }
        for(int i =0;i<n;i++){
            if(incCount[i]>=time && decCount[i]>=time){
                ans.add(i);
            }
        }
        System.out.println(Arrays.toString(decCount));
        System.out.println(Arrays.toString(incCount));
        return ans;
    }
}