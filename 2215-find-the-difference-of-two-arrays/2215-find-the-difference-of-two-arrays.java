class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> vis = new HashSet<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for(int i =0;i<nums1.length;i++){
            boolean found = false;
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    found = true;
                    break;
                }
            }
            if(!found && !vis.contains(nums1[i])) ans.get(0).add(nums1[i]);
            vis.add(nums1[i]);
        }
        vis.clear();
        for(int i =0;i<nums2.length;i++){
            boolean found = false;
            for(int j=0;j<nums1.length;j++){
                if(nums2[i]==nums1[j]){
                    found = true;
                    break;
                }
            }
            if(!found && !vis.contains(nums2[i])) ans.get(1).add(nums2[i]);
            vis.add(nums2[i]);
        }
        return ans;
    }
}