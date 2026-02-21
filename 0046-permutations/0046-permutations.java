class Solution {
    private void swap(int i,int index,int[]nums){
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
    private void f(int index,int[] nums, List<List<Integer>> ans){
        if(index==nums.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int num:nums) temp.add(num);
            ans.add(temp);
            return;
        }

        for(int i=index;i<nums.length;i++){
            swap(index,i,nums);
            f(index+1,nums,ans);
            swap(index,i,nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0,nums,ans);
        return ans;
    }
}




// class Solution {
//     private void f(int index,int [] nums,List<List<Integer>> ans,int[] check,List<Integer> temp){
//         if(index == nums.length){
//             ans.add(new ArrayList<>(temp));
//             return;
//         }
//         for(int i=0;i<nums.length;i++){
//             if(check[i]!=1){
//                 temp.add(nums[i]);
//                 check[i] = 1;
//                 f(index+1,nums,ans,check,temp);
//                 temp.remove(temp.size()-1);
//                 check[i] = 0;
//             }
//         }

//     } 
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         int[] check = new int[nums.length];
//         List<Integer> temp = new ArrayList<>();

//         f(0,nums,ans,check,temp);

//         return ans;

//     }
// }