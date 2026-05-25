class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int n =s.length();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        int farthest =0;
        while(!q.isEmpty()){
            int node = q.poll();
            int start = Math.max(node+minJump,farthest+1);
            int end = Math.min(node+maxJump,n-1);
            if(node==n-1) return true;
            for(int i = start;i<=end;i++){
                if(s.charAt(i)=='0' && !vis[i]){
                    vis[i] = true;
                    q.offer(i);
                }
            }
            farthest = end;
        }
        return false;
    }
}


// class Solution {
//     private boolean f(int index,String s, int min,int max,Boolean[] dp){
//         if(index == s.length()-1) return true;
//         if(index > s.length()-1) return false;
//         if(dp[index]!=null) return dp[index];
//         for(int i=0;i<=max-min;i++){
//             if(index+min+i<s.length() && s.charAt(index+min+i)=='0'){
//                if(f(index+min+i,s,min,max,dp)){
//                 return dp[index]=true;
//                }
//             }
//         }
//         return dp[index]=false;
//     }
//     public boolean canReach(String s, int minJump, int maxJump) {
//         Boolean[] dp = new Boolean[s.length()];
//         return f(0,s,minJump,maxJump,dp);
//     }
// }