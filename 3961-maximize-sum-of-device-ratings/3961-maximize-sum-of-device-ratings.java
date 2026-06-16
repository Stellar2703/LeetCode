class Solution {
    public long maxRatings(int[][] units) {
        long sum=0;
        long sum2=0;
        long firstmin=Integer.MAX_VALUE;
        long secondmin=Integer.MAX_VALUE;
        for(int i[]:units){
            int first=Integer.MAX_VALUE;
            int second=Integer.MAX_VALUE;
            for(int j:i){
                if(j<first){
                    second=first;
                    first=j;
                }
                else if(j<second){
                    second=j;
                }
            }
           if(i.length==1){
               second=0;
           }
            sum+=first;
            sum2+=second;
            firstmin=Math.min(firstmin,first);
            secondmin=Math.min(secondmin,second);
        }
        return Math.max(sum,(long)firstmin+sum2-secondmin);
    }
}