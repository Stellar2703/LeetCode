class Solution {
    private void f(int index,int [] nums,List<List<Integer>> ans,int[] check,List<Integer> temp){
        if(index == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(check[i]!=1){
                temp.add(nums[i]);
                check[i] = 1;
                f(index+1,nums,ans,check,temp);
                temp.remove(temp.size()-1);
                check[i] = 0;
            }
        }

    } 
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] check = new int[nums.length];
        List<Integer> temp = new ArrayList<>();

        f(0,nums,ans,check,temp);

        return ans;

    }
}


















// class Solution {
//     public void swap(int [] nums,int i,int j){
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }

//     public void getPermutations(int[] nums,List<List<Integer>> ans,int index){
//         if(index==nums.length){
//             List<Integer> temp = new ArrayList<>();
//             for (int num : nums) temp.add(num);
//             ans.add(temp);
//             return;
//         }
//         for(int i=index;i<nums.length;i++){
//             swap(nums,index,i);
//             getPermutations(nums,ans,index+1);
//             swap(nums,index,i);
//         }
//     }

//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         getPermutations(nums,ans,0);
//         return ans;
//     }
// }
