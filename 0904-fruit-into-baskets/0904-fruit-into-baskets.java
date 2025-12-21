// class Solution {
//     public int totalFruit(int[] fruits) {
//         HashMap<Integer,Integer> mp = new HashMap<>();
//         int l=0,max_len=0;
//         for (int r=0;r<fruits.length;r++){
//             mp.put(fruits[r],mp.getOrDefault(fruits[r],0)+1);
//             while (mp.size()>2){
//                 mp.put(fruits[l],mp.getOrDefault(fruits[l],0)-1);
//                 if (mp.get(fruits[l])==0){
//                     mp.remove(fruits[l]);
//                 }
//                 l++;

//             }
//         max_len=Math.max(max_len,r-l+1);
//         }
//         return max_len;
//     }
// }
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int l=0,max_len=0;
        for (int r=0;r<fruits.length;r++){
            mp.put(fruits[r],mp.getOrDefault(fruits[r],0)+1);
            if (mp.size()>2){
                mp.put(fruits[l],mp.getOrDefault(fruits[l],0)-1);
                if (mp.get(fruits[l])==0){
                    mp.remove(fruits[l]);
                }
                l++;

            }
        else max_len=Math.max(max_len,r-l+1);
        }
        return max_len;
    }
}