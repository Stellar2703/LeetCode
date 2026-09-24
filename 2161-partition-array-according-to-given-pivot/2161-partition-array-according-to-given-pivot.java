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
        for(int i =0;i<less.size();i++){
            ans[index] = less.get(i);
            index+=1;
        }
        for(int i =0;i<equal.size();i++){
            ans[index] = equal.get(i);
            index+=1;
        }
        for(int i =0;i<greater.size();i++){
            ans[index] = greater.get(i);
            index+=1;
        }
        return ans;
    }
}