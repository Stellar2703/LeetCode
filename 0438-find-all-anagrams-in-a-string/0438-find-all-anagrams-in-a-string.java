class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Charecter,Integer> req = new HashMap<>();
        HashMap<Charecter,Integer> win = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int l=0,formed=0,required=0;
        for(int i=0;i<p.length();i++){
            char temp = p.charAt(i);
            req.put(temp,req.getOrDefault(temp,0)+1);
        }
        required = req.size();
        for(int i=0;i<p.length();i++){
            win.put(s.charAt(i),win.getOrDefault(s.charAt(i),0)+1);
            if(req.containsKey(s.charAt(i)) && win.get(charAt(i)==req.get(charAt(i)))){
                formed++;
            }
        }
            if (formed == required) ans[] = l;
        for(int r=p.length()-1;r<s.length();r++){
            win.put(s.charAt(r),win.getOrDefault(s.charAt(r),0)+1);

            if(r-l+1<=p.length()){
                win.put(s.charAt(l),win.get(s.charAt(l))-1);
                formed--;
            }
            
            if (formed == required) ans[] = l;
    }
}