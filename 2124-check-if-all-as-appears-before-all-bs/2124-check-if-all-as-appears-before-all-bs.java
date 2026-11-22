class Solution {
    public boolean checkString(String s) {
        boolean b = false;
        for(char c : s.toCharArray()){
            if (c=='a' && b) return false;
            if(c=='b') b = true;
        }
        return true;
    }
}