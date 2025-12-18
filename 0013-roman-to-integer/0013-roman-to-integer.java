class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();
        int num = 0;
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        int ptr = 0;
        for(int i=1;i<s.length();i++){
            if (mp.get(s.charAt(ptr))>=mp.get(s.charAt(i))){
                num+=mp.get(s.charAt(ptr));
            }
            else{
                num-=mp.get(s.charAt(ptr));
            }
            ptr+=1;
        }
        num += mp.get(s.charAt(ptr));
        return num;
    }
}