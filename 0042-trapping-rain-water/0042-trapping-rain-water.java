class Solution {
    public int trap(int[] height) {
        // int n = height.length;
        // int [] prefix = new int[n];
        // int [] suffix = new int[n];
        // prefix[0]  = height [0];
        // for (int i=1;i<n;i++){
        //     prefix[i] = Math.max(prefix[i-1],height[i]);
        // }
        // suffix[n-1]  = height [n-1];
        // for (int i=n-2;i>=0;i--){
        //     suffix[i] = Math.max(suffix[i+1],height[i]);
        // }
        // int total = 0;
        // for (int i =0;i<n;i++){
        //     total+= (Math.min(prefix[i],suffix[i]))-height[i];
        // }

        // return total;



        int n = height.length;
        int l = 0 , r = n-1 , total = 0 , right = 0 , left = 0;
        while(l<r){
            if(height[l]<=height[r]){
                if(left>height[l]){
                    total += (left-height[l]);
                }
                left = Math.max(left,height[l]);
                l++;
            }else{
                if(right > height[r]){
                    total+= (right-height[r]);
                }
                right = Math.max(right,height[r]);
                r--;
            }
        }
        return total;
        }
    }