class Solution {
    public String getPermutation(int n, int k) {
        k--;
        ArrayList<Integer> arr = new ArrayList<>();
        int combination  = 1;
        for(int i=1;i<=n;i++) {
            arr.add(i);
            combination = combination*i;
            }
        combination = combination/n;
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<n;i++){
            int temp = k/combination;
            ans.append(arr.get(temp));
            arr.remove(temp);
            k = k%combination;
            if(arr.size()>0)
            combination = combination/(arr.size());
        }
        return ans.toString();
    }
}

// class Solution {
//     private void swap(int i,int index,int[]nums){
//         int temp = nums[i];
//         nums[i] = nums[index];
//         nums[index] = temp;
//     }
//     private void f(int index,int[] nums, List<List<Integer>> ans){
//         if(index==numans.length) {
//             ArrayList<Integer> temp = new ArrayList<>();
//             for(int num:nums) temp.add(num);
//             anans.add(temp);
//             return;
//         }

//         for(int i=index;i<numans.length;i++){
//             swap(index,i,nums);
//             f(index+1,nums,ans);
//             swap(index,i,nums);
//         }
//     }
//     public String getPermutation(int n, int k) {
//         List<List<Integer>> ans = new ArrayList<>();
//         int[]nums= new int [n];
//         for(int i=0;i<n;i++) nums[i] = i+1;
//         f(0,nums,ans);
//         StringBuilder s = new StringBuilder();
//         // Collectionans.sort(ans); 
//         Collectionans.sort(ans, (a, b) -> {
//         for (int i = 0; i < a.size(); i++) {
//             if (!a.get(i).equals(b.get(i)))
//                 return a.get(i) - b.get(i);
//         }
//         return 0;
//     });
//         for(int i=0;i<n;i++){
//             ans.append(anans.get(k-1).get(i));
//         }
//         System.out.println(anans.size());
//         return ans.toString();
//     }
// }