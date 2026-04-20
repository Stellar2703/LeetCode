class Solution {
    public int maxDistance(int[] colors) {

        // int ans = Integer.max_VALUE;
        // for(int i =0;i<colors.length;i++){
        //     for(int j=i+1;j<colors.length;j++){
        //         if(colors[i]!=colors[j]){
        //             ans = Math.max(ans,j-i);
        //         }
        //     }
        // }
        // return ans;

        int result = Integer.MIN_VALUE;
        for(int i =0;i<colors.length;i++){
            if(colors[i]!=colors[0]){
                result = Math.max(result,i);
            }

            if(colors[i]!= colors[colors.length-1]){
                result = Math.max(result,colors.length-i-1);
            }
        }

        return result;
    }
}