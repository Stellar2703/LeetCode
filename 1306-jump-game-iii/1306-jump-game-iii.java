class Solution {
    private boolean f(int index,int[] arr,boolean[] vis,Boolean[] dp){
        if(vis[index]== true) return false;
        if(arr[index]==0) return true;
        if(dp[index]!= null) return dp[index];
        boolean front=false;
        boolean back=false;
        if(arr[index]+index<arr.length){
            vis[index] = true;
            front = f(index+arr[index],arr,vis,dp);
        }
        if(index-arr[index]>=0){
            vis[index] = true;
            back = f(index-arr[index],arr,vis,dp);
        }
        return dp[index] = back || front;
    }   
    public boolean canReach(int[] arr, int start) {
        boolean[] vis = new boolean[arr.length];
        Boolean[] dp = new Boolean[arr.length];
        return f(start,arr,vis,dp);
    }
}