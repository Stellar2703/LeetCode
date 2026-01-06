class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> present = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int req = need.size();
        int l = 0,min = Integer.MAX_VALUE,formed = 0,start=0,r=0;
        while(r<s.length()){
            char comp = s.charAt(r);
            present.put(comp,present.getOrDefault(comp,0)+1);
            if(need.containsKey(comp)&& present.get(comp)==need.get(comp)){
                formed++;
            }
            while(formed==req){
                if(min>r-l+1){
                    min = r-l+1;
                    start = l;
                }
                char left = s.charAt(l);
                present.put(left,present.get(left)-1);
                if(need.containsKey(left) && need.get(left)>present.get(left)){
                    formed--;
                }
                l++;
            }
            r++;
        }   
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);

        }
    }
