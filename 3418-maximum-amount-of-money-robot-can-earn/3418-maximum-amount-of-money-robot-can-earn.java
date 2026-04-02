class Solution {
    int ans =Integer.MIN_VALUE;
    public void f(int i,int j,int count,int[][] coins,int sum){
        if(i==coins.length-1 && j==coins[0].length-1){
            if(coins[i][j]<0 && count <=1){
            ans = Math.max(sum,ans);
            return;
            }
            ans = Math.max(sum+coins[i][j],ans);
            return;
        }
        if(i>coins.length-1 || j>coins[0].length-1){
            return;
        }

        if(coins[i][j]>0){
            sum+=coins[i][j];
            f(i+1,j,count,coins,sum);
            f(i,j+1,count,coins,sum);
        }
        else{
            if(count<2){
            f(i+1,j,count+1,coins,sum);
            f(i,j+1,count+1,coins,sum);
            }

            f(i+1,j,count,coins,sum+coins[i][j]);
            f(i,j+1,count,coins,sum+coins[i][j]);
        }
    }
    public int maximumAmount(int[][] coins) {
        f(0,0,0,coins,0);
        return ans;
    }
}