class Solution {
    final int MOD = (int)10e8+7;
    public int numOfSubarrays(int[] arr) {
        
        int n  = arr.length;
        long ans = 0;
        // Brute Force

        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         int sum = 0;
        //         for(int k=i;k<=j;k++){
        //             sum+=arr[k];
        //         }
        //         if(sum%2!=0)ans++;
        //     }
        // }
        // return ans;


        // Better

    //     for(int i=0;i<n;i++){
    //             int sum = 0;
    //         for(int j=i;j<n;j++){
    //             sum+=arr[j];
    //             if(sum%2!=0)ans++;
    //         }
    //     }
    //     return ans;


    // Better 2

    // int [] prefix = new int[n];
    // prefix[0] = arr[0];
    // for(int i =1;i<n;i++){
    //     prefix[i] = arr[i]+prefix[i-1];
    // }
    // int oddCount =0,evenCount=1;
    // for(int i =0;i<n;i++){
    //     if(prefix[i]%2==0){
    //         ans+=oddCount;
    //         evenCount++;
    //     }
    //     else{
    //         ans+=evenCount;
    //         oddCount++;
    //     }
    // }
    // return (int)(ans%MOD);


    // Optimal
    int oddCount =0,evenCount=1;
    long sum =0;
    for(int i =0;i<n;i++){
        sum+= arr[i];
        if(sum%2==0){
            ans+=oddCount;
            evenCount++;
        }
        else{
            ans+=evenCount;
            oddCount++;
        }
    }
    return (int)(ans%MOD);
    }
}