class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge = new int[nums2.length];
        // for(int i =0;i<nums2.length;i++) nge[i] = -1;
        Arrays.fill(nge,-1);
        for(int i=0;i<nums2.length;i++){
            for(int j=i+1;j<nums2.length;j++){
                if(nums2[j]>nums2[i]){
                    nge[i]=nums2[j];
                    break;
                }
            }
        }

        int [] res = new int[nums1.length];
        for(int i =0;i<nums1.length;i++){
            for(int j = 0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    res[i] = nge[j];
                    break;
                }
            }
        }

        return res;
    }
}