class Solution {
//     public int minAddToMakeValid(String s) {
//         Stack<Character> st = new Stack<>();
//         for(char c : s.t    oCharArray()){
//             if(c==')'){
//                 if(!st.isEmpty() && st.peek()=='('){
//                     st.pop();
//                 }
//                 else{
//                     st.push(c);
//                 }
//             }
//             else{
//                     st.push(c);
//                 }
//         }
//         return st.size();
//     }
// }


public int minAddToMakeValid(String s) {
    int open = 0; // count of unmatched '('
    int close = 0; // count of unmatched ')'

    for(char c : s.toCharArray()){
        if(c=='('){
            open++;
        } else {
            if(open>0){
                open--; // match with '('
            } else {
                close++; // unmatched ')'
            }
        }
    }
    return open + close;
}
}