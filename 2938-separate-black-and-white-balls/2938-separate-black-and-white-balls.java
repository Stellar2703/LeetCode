class Solution {
    public long minimumSteps(String s) {
        long ones = 0;
        long moves = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                ones++;
            }
            else{
                moves+=ones;
            }
        }
        return moves;
    }
}