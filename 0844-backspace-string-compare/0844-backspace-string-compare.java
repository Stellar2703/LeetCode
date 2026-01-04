    class Solution {
        public boolean backspaceCompare(String s, String t) {
            int a=s.length()-1,b=t.length()-1;
            while(a>=0 || b>=0){
                int count1 = 0,count2 = 0;
                while(a>=0){
                    if(s.charAt(a)=='#'){
                        count1+=1;
                        a--;
                        }
                    else if (count1> 0){
                    a--;
                    count1--;
                    }
                    else break;
                }
                while(b>=0){
                    if(t.charAt(b)=='#'){
                        count2+=1;
                        b--;
                        }
                    else if (count2> 0){
                    b--;
                    count2--;
                    }
                    else break;
                }

                if(a>=0 && b>=0){
                    if(s.charAt(a)!=t.charAt(b)) return false;
                }
                else if (a>=0 || b>=0) return false;
                a--;
                b--;  
            }
            return true;
        }
    }