class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greater= new ArrayList<>();
        for(int i :nums){
            if(i<pivot){
                less.add(i);
            }
            else if(i==pivot){
                equal.add(i);
            }
            else{
                greater.add(i);
            }
        }

        int [] ans = new int[nums.length];
        int index = 0;
        for(int i:less)ans[index++] = i;
        for(int i:equal)ans[index++] = i;
        for(int i:greater)ans[index++] = i;
        return ans;
    }
}