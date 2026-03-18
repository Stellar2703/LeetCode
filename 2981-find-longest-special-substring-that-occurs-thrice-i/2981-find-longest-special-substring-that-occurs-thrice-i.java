    class Solution {
        public int maximumLength(String s) {
            HashMap<String,Integer> mp = new HashMap<>();
            int ans = -1;
            for(int i=0;i<s.length();i++){
                for(int j=i;j<s.length();j++){  
                    String temp = s.substring(i,j+1);
                    if(isSpecial(temp)){
                        mp.put(temp,mp.getOrDefault(temp,0)+1);
                        if(mp.get(temp)>=3){
                            ans = Math.max(ans,temp.length());
                        }
                    }
                }
            }
            return ans;
        }


        public boolean isSpecial(String s){
            char c = s.charAt(0);
            for(int i =0;i<s.length();i++){
                if(s.charAt(i)!=c)return false;
            }
            return true;
        }
    }