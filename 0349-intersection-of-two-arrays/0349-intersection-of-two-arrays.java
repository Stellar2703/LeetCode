class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
        // int [] ans = new int[Math.min(nums1.length,nums2.length)];
        // int l=0,r=0,i = 0;
        // while (l < nums1.length && r < nums2.length){
        //     if (l > 0 && nums1[l] == nums1[l - 1]) {
        //         l++;
        //         continue;
        //     }
        //     if (r > 0 && nums2[r] == nums2[r - 1]) {
        //         r++;
        //         continue;
        //     }
        //     if(nums1[l]==nums2[r]) {
        //     ans[i]=nums1[l];
        //     l++;
        //     i++;
        //     r++;
        //     }
        //     else if (nums1[l]>nums2[r]) r++;
        //     else l++;
        // }
        // return Arrays.copyOf(ans, i);

        HashSet <Integer> ans  = new HashSet<>();
        HashSet <Integer> temp  = new HashSet<>();
        for (int n : nums1) temp.add(n);
        for (int n: nums2) if(temp.contains(n)) ans.add(n);
        int [] arr = new int[ans.size()];
        int i=0;
        for(int n : ans) arr[i++]=n;
        return arr;

    }
}