// class Solution {
//     public String largestMerge(String word1, String word2) {
//         StringBuilder sb = new StringBuilder();
//         int w1 = 0;
//         int w2 = 0;
//         int l1 = word1.length(); 
//         int l2 = word2.length(); 
//         while(w1<l1 && w2<l2){
//             if(word1.charAt(w1)>word2.charAt(w2)){
//                 sb.append(word1.charAt(w1));
//                 w1++;
//             }
//             else if(word1.charAt(w1)<word2.charAt(w2)){
//                 sb.append(word2.charAt(w2));
//                 w2++;
//             }
//             else{
//                 int t1 = w1;
//                 int t2 = w2;
//                 while(t1<l1 && t2<l2 && word1.charAt(t1)==word2.charAt(t2)){
//                     sb.append(word1.charAt(t1));
//                     t1++;
//                     t2++;
//                 }
//                 if(t1<l1 && t2<l2 && word1.charAt(t1)>word2.charAt(t2)){
//                         sb.append(word1.charAt(t1));
//                         w1 = t1+1;
//                 }
//                 else if(t1<l1 && t2<l2 && word1.charAt(t1)<word2.charAt(t2)){
//                         sb.append(word2.charAt(t2));
//                         w2=t2+1;
//                 }
//                 else if(t1==l1 && t2<l2){
//                     sb.append(word2.charAt(t2));
//                     w2 = t2+1;
//                 }
//                 else if (t2>=l2 && t1<l1){
//                     sb.append(word1.charAt(t1));
//                     w1 = t1+1;
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }
//         while(w1<l1){
//             sb.append(word1.charAt(w1));
//             w1++;
//         }
//         while(w2<l2){
//             sb.append(word2.charAt(w2));
//             w2++;
//         }
//         return sb.toString();
//     }
// }


class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int w1 = 0;
        int w2 = 0;
        int l1 = word1.length(); 
        int l2 = word2.length(); 
        while(w1 < l1 && w2 < l2){
            if(word1.charAt(w1) > word2.charAt(w2)){
                sb.append(word1.charAt(w1));
                w1++;
            }
            else if(word1.charAt(w1) < word2.charAt(w2)){
                sb.append(word2.charAt(w2));
                w2++;
            }
            else {
                int t1 = w1;
                int t2 = w2;
                // MINIMAL CHANGE 1: Remove sb.append from this loop. 
                // Use it strictly to find where the tie breaks.
                while(t1 < l1 && t2 < l2 && word1.charAt(t1) == word2.charAt(t2)){
                    t1++;
                    t2++;
                }
                
                // MINIMAL CHANGE 2: Only append ONE character and advance the 
                // corresponding main pointer by 1 based on the lookahead result.
                if(t1 < l1 && t2 < l2 && word1.charAt(t1) > word2.charAt(t2)){
                    sb.append(word1.charAt(w1));
                    w1++;
                }
                else if(t1 < l1 && t2 < l2 && word1.charAt(t1) < word2.charAt(t2)){
                    sb.append(word2.charAt(w2));
                    w2++;
                }
                // If t1 reaches the end, word2 is longer/better remaining string
                else if(t1 >= l1 && t2 < l2){
                    sb.append(word2.charAt(w2));
                    w2++;
                }
                // If t2 reaches the end, word1 is longer/better remaining string
                else if (t2 >= l2 && t1 < l1){
                    sb.append(word1.charAt(w1));
                    w1++;
                }
                else {
                    // Both strings are identical till the end, pick either
                    sb.append(word1.charAt(w1));
                    w1++;
                }
            }
        }
        while(w1 < l1){
            sb.append(word1.charAt(w1));
            w1++;
        }
        while(w2 < l2){
            sb.append(word2.charAt(w2));
            w2++;
        }
        return sb.toString();
    }
}