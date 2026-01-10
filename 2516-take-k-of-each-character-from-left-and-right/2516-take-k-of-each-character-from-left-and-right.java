class Solution {
    public int takeCharacters(String s, int k) {
        int couA=0,couB=0,couC=0,caclA=0,caclB=0,caclC=0,ans=0,reqA=0,reqB=0,reqC=0,l=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a') couA++;
            if(s.charAt(i)=='b') couB++;
            if(s.charAt(i)=='c') couC++;
        }
        if (k > couA || k > couB || k > couC) return -1;
        reqA = couA-k;
        reqB = couB-k;
        reqC = couC-k;
        for(int r=0;r<s.length();r++){
            if(s.charAt(r)=='a') caclA++;
            if(s.charAt(r)=='b') caclB++;
            if(s.charAt(r)=='c') caclC++;
            while((caclA> reqA || caclB> reqB || caclC> reqC ) && l<=r ){
                if(s.charAt(l)=='a') caclA--;
                if(s.charAt(l)=='b') caclB--;
                if(s.charAt(l)=='c') caclC--;
                l++;
            }
            ans = Math.max(ans,(r-l+1));
        }
        return s.length()-ans;
    }
}