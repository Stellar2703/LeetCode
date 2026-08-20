class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int [] arr1 = new int[n];
        int [] arr2 = new int[n];
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int first = 1,second = 1;
        for(int i =2;i<n;i++){ 
            if(arr1[first-1]>arr2[second-1]){
                arr1[first] = nums[i];
                first++;
            }
            else{
                arr2[second] = nums[i];
                second++;
            }
        }
        // first = 0;
        second = 0;
        // while(arr1[first]!=0){
        //     nums[first] = arr1[first];
        //     first++;
        // }
        while(arr2[second]!=0){
            arr1[first+second] = arr2[second];
            second++;
        }
        return arr1;
        
    }
}