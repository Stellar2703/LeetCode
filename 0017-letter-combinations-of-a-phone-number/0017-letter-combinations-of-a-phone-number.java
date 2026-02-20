class Solution {
    public void f(String digits,int index,HashMap<Character,String> mp,StringBuilder temp,
    List<String> ans){
        if(index>=digits.length()) {
            ans.add(temp.toString());
            return;
        }
        int len = mp.get(digits.charAt(index)).length();
        for(int i=0;i<len;i++){
            temp.append(mp.get(digits.charAt(index)).charAt(i));
            f(digits,index+1,mp,temp,ans);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> mp = new HashMap<>();
        StringBuilder temp = new StringBuilder();
        List<String> ans = new ArrayList<>();
        mp.put('2',"abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");
        f(digits,0,mp,temp,ans);
        return ans;
    }
}