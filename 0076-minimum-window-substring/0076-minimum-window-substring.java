class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> present = new HashMap<>();
        int l=0,r=0,min=Integer.MAX_VALUE,formed = 0,start =0;
        for(int i =0;i<t.length();i++){
            char temp= t.charAt(i);
            need.put(temp,need.getOrDefault(temp,0)+1);
        }
        int req = need.size();

        while(r<s.length()){
            char right = s.charAt(r);
            present.put(right,present.getOrDefault(right,0)+1);
            if(need.containsKey(right) && present.get(right).intValue()==need.get(right).intValue()) formed++;

            while(formed == req){
                if(min>r-l+1){
                    min = r-l+1;
                    start = l;
                }
                char left = s.charAt(l);
                present.put(left,present.get(left)-1);
                if(need.containsKey(left)&&present.get(left)<need.get(left)){
                    formed--;
                }
                    l++;
            }
            r++;
        }

            return min == Integer.MAX_VALUE ? "" : s.substring(start,start+min);
    }
}