class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int freq = 0,ans = 0,l=0;
        for(int r =0;r<s.length();r++){
            arr[s.charAt(r)-'A']+=1;
            freq = Math.max(arr[s.charAt(r)-'A'],freq);
            if((r-l+1-freq)>k ){
                arr[s.charAt(l)-'A']-=1;
                l++;
            }
            ans = Math.max(ans,r-l+1);
            // System.out.println(l+" "+r);
        }
        return ans;
    }
}