// class Solution {
//     public int characterReplacement(String s, int k) {
//         HashMap<Character,Integer> mp = new HashMap<>();
//         int l=0,freq=0,ans = 0;
//         for(int r=0;r<s.length();r++){
//             char right = s.charAt(r);
//             mp.put(right,mp.getOrDefault(right,0)+1);
//             freq = Math.max(freq,mp.get(right));
//             if(r-l+1-freq<=k){
//                 ans = Math.max(r-l+1,ans);
//             }
//             char left = s.charAt(l);
//             if(r-l+1-freq>k){
//                 mp.put(left,mp.get(left)-1);
//                 l++;
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0, maxFreq = 0, ans = 0;

        for (int r = 0; r < s.length(); r++) {
            int idx = s.charAt(r) - 'A';
            count[idx]++;
            maxFreq = Math.max(maxFreq, count[idx]);

            if (r - l + 1 - maxFreq > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
