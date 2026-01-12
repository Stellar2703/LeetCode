class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int formed = 0 , required =0 , l = 0;
        HashMap<Character,Integer> mp = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char temp = s1.charAt(i);
            mp.put(temp,mp.getOrDefault(temp,0)+1);
        }
        required = mp.size();
        for(int r=0;r<s2.length();r++){
            char temp = s2.charAt(r);
            window.put(temp,window.getOrDefault(temp,0)+1);
            if(mp.containsKey(temp) && window.get(temp).intValue() == mp.get(temp).intValue()){
                formed ++;
            }
            while(r-l+1 > s1.length()){
                if(mp.containsKey(s2.charAt(l)) && window.get(s2.charAt(l)).intValue() == mp.get(s2.charAt(l)).intValue()){
                    formed--;
                }
                window.put(s2.charAt(l),window.get(s2.charAt(l))-1);
                l++;
            }
            if(formed == required  ) return true;
        }
        return false;
    }
}